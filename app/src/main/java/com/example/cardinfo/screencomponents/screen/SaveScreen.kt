package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
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
import com.example.cardinfo.room.CardDetails
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SaveScreen(
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
    navController: NavHostController,
) {

    val inputInfoCard by cardDetailsViewModel.allDetails.observeAsState(emptyList())
    val updateItemsState = rememberUpdatedState(inputInfoCard)

    // Calling a class to give the card number the correct look
    val formatNumberCard = FormatNumberCard()


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item( inputInfoCard ){
            updateItemsState.value.map { item->
                SwipeToDeleteList(
                    item = item,
                    onDelete = { cardDetailsViewModel.deleteDetails(item) },
                    onClick = { navController.navigate("${ConstantValue.INFORMATION_SAVED_SCREEN}/${item.id}")},
                    formatNumberCard = formatNumberCard,
                )
            }
        }
    }

    LaunchedEffect(Unit){
        cardDetailsViewModel.refreshData()
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        contentAlignment = Alignment.BottomCenter,
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDeleteList(
    item: CardDetails,
    onDelete: () -> Unit,
    onClick: () -> Unit,
    formatNumberCard: FormatNumberCard,
) {

    val dismissState = rememberDismissState (
        confirmStateChange = {
            if (it == DismissValue.DismissedToEnd) {
                onDelete()
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
                onClick()
            },
    )
}




