package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
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
            inputInfoCard.map {
                Card(
                    modifier = Modifier
                        .background(Color.White)
                        .clickable {
                            navController.navigate("$INFORMATION_SAVED_SCREEN/${it.id}")
                        }
                        .swipeable(
                            state = swipeableState,
                            anchors = anchors,
                            thresholds = { _, _ -> FractionalThreshold(0.3f) },
                            orientation = Orientation.Horizontal
                        ),
                    backgroundColor = Color.Red
                ) {
                    Card(
                        Modifier
                            .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) },
                        backgroundColor = Color.DarkGray,

                    ) {
                        Text(
                            text = it.DetailsCard,
                            Modifier
                                .fillMaxWidth()
                                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                                .height(47.dp),
                            color = Color.White,
                            style = TextStyle(fontSize = 15.sp)
                        )
                    }
                }
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




