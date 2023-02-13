package com.example.cardinfo.functions

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.cardinfo.data.CardModel

class MainViewModel(): ViewModel() {

    var cardNumber by mutableStateOf("")
        private set

    val cardInfoCardModel = mutableStateOf(listOf<CardModel>())
    // The number of characters after which the request is sent
    val characterLimitSubmittingRequest = mutableStateOf(4)

    val checkingFirstRequest = mutableStateOf(false)
    val pattern = Regex("^\\d+\$")











}