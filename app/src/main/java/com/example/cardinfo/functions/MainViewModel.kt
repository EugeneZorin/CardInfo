package com.example.cardinfo.functions

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.cardinfo.data.CardModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(CardModel())
    val uiState: StateFlow<CardModel> = _uiState.asStateFlow()

    val cardInfoCardModel = mutableStateOf(listOf<CardModel>())

    // The number of characters after which the request is sent
    val characterLimitSubmittingRequest = mutableStateOf(4)

    val checkingFirstRequest = mutableStateOf(false)
    val pattern = Regex("^\\d+\$")

    var cardNumber by mutableStateOf("")

}