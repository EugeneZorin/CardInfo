package com.example.cardinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cardinfo.components.*
import com.example.cardinfo.data.CardModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    val cardInfoCardModel = remember {
        mutableStateOf(listOf<CardModel>())
    }

    // The number of characters after which the request is sent
    val characterLimitSubmittingRequest = remember {
        mutableStateOf(4)
    }

    Box (modifier = Modifier
        .offset(x = 50.dp, y = 20.dp)
        .fillMaxSize())
    {
        CardNumberEntry(cardInfoCardModel, characterLimitSubmittingRequest)
    }

    Row(modifier = Modifier
        .offset(x = 30.dp, y = 50.dp)) {

        Box (modifier = Modifier
            .offset(x = 5.dp, y = 50.dp))
        {
            CardDataOutputOneColum(cardInfoCardModel) }

        Box (modifier = Modifier
            .offset(x = 95.dp, y = 50.dp))
        {
            CardDataOutputTwoColum(cardInfoCardModel) }

        /*Column () {
            Box (modifier = Modifier
                .offset(x = 50.dp, y = 20.dp))
            {
                CardNumberEntry(cardInfoCardModel, characterLimitSubmittingRequest)
            }

            Box (modifier = Modifier
                .offset(x = 15.dp, y = 50.dp))
            {
                CardDataOutputOneColum(cardInfoCardModel) }
        }*/

        /*Column() {
            Box (modifier = Modifier
                .offset(x = 15.dp, y = 50.dp))
            {
                CardDataOutputTwoColum(cardInfoCardModel) }
        }*/

    }


}