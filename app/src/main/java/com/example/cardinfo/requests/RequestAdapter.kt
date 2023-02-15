package com.example.cardinfo.requests

import android.content.SharedPreferences
import com.example.cardinfo.DATA_TEST_VALUE
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.functions.MainViewModel
import com.google.gson.GsonBuilder
import okhttp3.Response

class RequestAdapter {

    fun requestAdapter(responseSaveData: List<Response>, preferences: SharedPreferences): List<CardModel> {
        val gson = GsonBuilder().create()


        val response = responseSaveData[0].body.string()
        val responseCode = responseSaveData[0].code

        if (responseCode < 400){
            preferences.edit().putString(DATA_TEST_VALUE, response).apply()
        }

        return if (responseCode > 400) {
            listOf(CardModel(errorHandler = true))

        } else {
            listOf(gson.fromJson(response, CardModel::class.java))
        }

    }
}