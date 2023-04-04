package com.example.cardinfo.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.BRACKETS_WITHOUT_SPACES
import com.example.cardinfo.data.constant.ConstantValue.FOUR
import kotlinx.coroutines.launch
import okhttp3.Response

class MainViewModel : ViewModel() {

    var cardNumber by mutableStateOf(BRACKETS_WITHOUT_SPACES)

    // The main storage is data for the view
    val infoCardModel = mutableStateOf(listOf<CardModel>())

    // Saves the entered json values from the server
    val responseSaveData = mutableStateOf(listOf<Response>())

}