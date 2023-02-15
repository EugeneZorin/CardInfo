package com.example.cardinfo.functions

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.cardinfo.data.CardModel
import okhttp3.Response

class MainViewModel(): ViewModel() {

    var cardNumber by mutableStateOf("")
        private set

    val cardInfoCardModel = mutableStateOf(listOf<CardModel>())

    val responseSaveData = mutableStateOf(listOf<Response>())
    // The number of characters after which the request is sent
    val characterLimitSubmittingRequest = mutableStateOf(4)


    val checkingFirstRequest = mutableStateOf(false)
    val pattern = Regex("^\\d+\$")

}