package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.data.constant.ConstantValue
import com.example.cardinfo.data.constant.ConstantValue.MAIN_SCREEN
import com.example.cardinfo.functions.FormatNumberCard
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SaveScreen(
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
    navController: NavHostController,
) {
    val inputInfoCard = cardDetailsViewModel.allDetails.observeAsState(emptyList()).value

    // Calling a class to give the card number the correct look
    val formatNumberCard = FormatNumberCard()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        item { 
            inputInfoCard.map { item->

                val dismissState = rememberDismissState (
                    confirmStateChange = {
                        if (it == DismissValue.DismissedToEnd) {
                            cardDetailsViewModel.deleteDetails(item)
                        }
                        true
                    }
                )

                SwipeToDismiss(
                    state = dismissState,
                    dismissThresholds = { FractionalThreshold(0.5f) },
                    directions = setOf(DismissDirection.StartToEnd),
                    dismissContent = {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(65.dp)
                                .padding(5.dp)

                        ) {
                            Text(
                                text = formatNumberCard.formatNumberCard(item.numberCard),
                                fontSize = 30.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.offset(y =  7.dp)

                            )
                        }


                    },
                    background = { Color.DarkGray },
                    modifier = Modifier
                        .clickable {

                            // Send ID to screen InformationSavedScreen
                            navController.navigate("${ConstantValue.INFORMATION_SAVED_SCREEN}/${item.id}")
                        },
                    )

                }


            }
        }


    Box(modifier = Modifier
        .offset(x = 144.dp, y = 690.dp)
        .fillMaxSize()
    ) {
        Button(
            onClick = { navController.navigate(MAIN_SCREEN) },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .padding(2.dp)
        ) {
            Text(text = "Назад")
        }
    }

}




