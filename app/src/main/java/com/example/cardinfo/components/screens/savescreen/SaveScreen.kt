package com.example.cardinfo.components.screens.savescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardinfo.components.screens.savescreen.components.ButtonBack
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel

@Composable
fun SaveScreen(cardDetailsViewModel: CardDetailsViewModel) {

    val inputInfoCard = cardDetailsViewModel.allDetails.observeAsState(emptyList()).value

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            inputInfoCard.map { it ->
                Card(
                    modifier = Modifier
                        .offset(x = 20.dp, y = 20.dp)
                        .height(45.dp)
                        .width(370.dp)
                        .padding(top = 3.dp)
                        .clickable {
                            /*cardDetailsViewModel.deleteDetails(it)*/
                        },
                    backgroundColor = Color.Blue,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(5.dp)
                )
                {
                    Text(
                        text = it.DetailsCard,
                        color = Color.White,
                        style = TextStyle(fontSize = 15.sp)
                    )
                }
            }
        }
    }

    Box(modifier = Modifier
        .offset(x = 145.dp, y = 570.dp)
        .fillMaxSize())
    {
        ButtonBack()
    }
}
