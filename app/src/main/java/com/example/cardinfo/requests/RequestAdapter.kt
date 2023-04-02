package com.example.cardinfo.requests

import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.ERROR_FOUR_HUNDRED
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.viewmodelshared.ViewModelSharedPreferences
import com.google.gson.GsonBuilder
import okhttp3.Response

class RequestAdapter {

    fun requestAdapter(
        responseSaveData: List<Response>,
        preferencesHomeScreenValue: ViewModelSharedPreferences,
        cardNumberRemember: String
    ): List<CardModel> {
        val gson = GsonBuilder().create()


        val response = responseSaveData[0].body.string()
        val responseCode = responseSaveData[0].code

        if (responseCode < ERROR_FOUR_HUNDRED){
            preferencesHomeScreenValue.saveData(HOME_SCREEN_VALUES, response)
            preferencesHomeScreenValue.saveData(INPUT_VALUE, cardNumberRemember)

        }

        return if (responseCode > ERROR_FOUR_HUNDRED) {
            listOf(CardModel(errorHandler = true))

        } else {
            listOf(gson.fromJson(response, CardModel::class.java))
        }

    }
}