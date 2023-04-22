package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.data.constant.ConstantValue
import com.example.cardinfo.data.constant.ConstantValue.MAIN_SCREEN
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SaveScreen(
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
    navController: NavHostController,
) {
    val inputInfoCard = cardDetailsViewModel.allDetails.observeAsState(emptyList()).value

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
                        Text(text = item.numberCard)

                    },
                    background = { Color.DarkGray },
                    modifier = Modifier.clickable {

                        // Send ID to screen InformationSavedScreen
                        navController.navigate("${ConstantValue.INFORMATION_SAVED_SCREEN}/${item.id}")
                    },

                )
            }
        }
    }

    Box(modifier = Modifier
        .offset(x = 150.dp, y = 570.dp)
        .fillMaxSize())
    {
        Button(onClick = { navController.navigate(MAIN_SCREEN) }) {
            Text(text = "Назад")
        }
    }
}




