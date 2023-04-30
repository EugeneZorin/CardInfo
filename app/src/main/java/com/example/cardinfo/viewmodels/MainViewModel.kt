package com.example.cardinfo.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.NULL
import com.google.gson.GsonBuilder
import okhttp3.Response

class MainViewModel : ViewModel() {

    // The main storage is data for the view
    val infoCardModel = mutableStateOf(listOf<CardModel>())

    // Saves the entered json values from the server
    val responseSaveData = mutableStateOf(listOf<Response>())

    val checkingMessageError = mutableStateOf(false)

    val noInternetMessage = mutableStateOf(false)

    // To display saved data on the screen
    fun outputAdapter(userDao: String): MutableState<List<CardModel>> {
        if( userDao.isNotEmpty() && userDao != NULL ){
            infoCardModel.value =
                listOf(
                    GsonBuilder().create()
                        .fromJson(userDao, CardModel::class.java)
                )

        }
        return infoCardModel
    }

}