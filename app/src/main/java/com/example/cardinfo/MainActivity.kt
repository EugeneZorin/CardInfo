package com.example.cardinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinfo.components.*
import com.example.cardinfo.data.CardModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val cardInfoCardModel = remember {
                mutableStateOf(listOf<CardModel>())
            }

            // The number of characters after which the request is sent
            val characterLimitSubmittingRequest = remember {
                mutableStateOf(4)
            }

            Column (modifier = Modifier
                .fillMaxSize()
            ) {
                Box (modifier = Modifier
                    .offset(x = 50.dp, y = 20.dp))
                {
                    CardNumberEntry(cardInfoCardModel, characterLimitSubmittingRequest)
                }

                Box (modifier = Modifier
                    .offset(x = 15.dp, y = 50.dp))
                {
                    CardDataOutput(cardInfoCardModel) }
            }
        }
    }
}


