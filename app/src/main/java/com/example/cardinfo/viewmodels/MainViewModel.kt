package com.example.cardinfo.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.BRACKETS_WITHOUT_SPACES
import com.example.cardinfo.room.CardNumberDetails
import com.google.gson.GsonBuilder
import okhttp3.Response

class MainViewModel : ViewModel() {

    // The main storage is data for the view
    val infoCardModel = mutableStateOf(listOf<CardModel>())

    // Saves the entered json values from the server
    val responseSaveData = mutableStateOf(listOf<Response>())

    fun outputAdapter(userDao: List<CardNumberDetails>, id: Int?): MutableState<List<CardModel>> {
        if(userDao.isNotEmpty()){
            infoCardModel.value =
                listOf(
                    GsonBuilder().create()
                        .fromJson(userDao[id!!]
                            .numberCard, CardModel::class.java)
                )
        }
        return infoCardModel
    }

}