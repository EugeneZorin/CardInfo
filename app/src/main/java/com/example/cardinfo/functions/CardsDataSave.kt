package com.example.cardinfo.functions

import android.content.SharedPreferences
import androidx.compose.runtime.MutableState
import com.example.cardinfo.data.CardModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class CardsDataSave {

    private val gson: Gson = GsonBuilder().create()

    fun cardDataSave(
        saveCardsInformation: MutableState<SharedPreferences?>,
        cardInfoCardModel: MutableState<List<CardModel>>
    ) {

        if (saveCardsInformation.value?.getString("FirsData", null) != null){
            cardInfoCardModel.value = listOf(gson.fromJson
                (saveCardsInformation
                .value?.getString("FirsData", null)
                .toString(), CardModel::class.java))
        }
    }
}