package com.example.cardinfo.requests

import android.content.SharedPreferences
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.ConstantValue.ERROR_FOUR_HUNDRED
import com.example.cardinfo.data.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.ConstantValue.INPUT_VALUE
import com.google.gson.GsonBuilder
import okhttp3.Response

class RequestAdapter {

    fun requestAdapter(
        responseSaveData: List<Response>,
        preferencesHomeScreenValue: SharedPreferences,
        cardNumberRemember: String
    ): List<CardModel> {
        val gson = GsonBuilder().create()


        val response = responseSaveData[0].body.string()
        val responseCode = responseSaveData[0].code

        if (responseCode < ERROR_FOUR_HUNDRED){
            preferencesHomeScreenValue.edit().putString(HOME_SCREEN_VALUES, response).apply()
            preferencesHomeScreenValue.edit().putString(INPUT_VALUE, cardNumberRemember).apply()

        }

        return if (responseCode > ERROR_FOUR_HUNDRED) {
            listOf(CardModel(errorHandler = true))

        } else {
            listOf(gson.fromJson(response, CardModel::class.java))
        }

    }
}