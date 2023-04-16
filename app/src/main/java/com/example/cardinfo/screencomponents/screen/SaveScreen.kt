package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.data.constant.ConstantValue.INFORMATION_SAVED_SCREEN
import com.example.cardinfo.data.constant.ConstantValue.MAIN_SCREEN
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SaveScreen(
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
    navController: NavHostController,
) {

    val inputInfoCard = cardDetailsViewModel.allDetails.observeAsState(emptyList()).value

    val squareSize = 45.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states
    
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
                                     Text(text = item.DetailsCard)

                    },
                    background = {
                        Color.DarkGray

                    }


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




