package com.example.cardinfo.functions

import android.content.SharedPreferences
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.ConstantValue.BRACKETS_WITHOUT_SPACES
import com.example.cardinfo.data.ConstantValue.FOUR
import okhttp3.Response

class MainViewModel : ViewModel() {

    //
    var cardNumber by mutableStateOf(BRACKETS_WITHOUT_SPACES)

    // The main storage is data for the view
    val infoCardModel = mutableStateOf(listOf<CardModel>())

    // Saves the entered json values from the server
    val responseSaveData = mutableStateOf(listOf<Response>())

    // The number of characters after which the request is sent
    val characterLimitSubmittingRequest = mutableStateOf(FOUR)

    //
    val checkingFirstRequest = mutableStateOf(false)







}