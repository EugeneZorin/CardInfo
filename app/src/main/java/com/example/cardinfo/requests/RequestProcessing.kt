package com.example.cardinfo.requests

import android.content.SharedPreferences
import androidx.compose.runtime.MutableState
import com.example.cardinfo.data.CardModel
import com.google.gson.GsonBuilder
import okhttp3.*


class RequestProcessing(){

    private val client = OkHttpClient()

    private fun Request.Builder.endpoint(endpoint: String): Request.Builder {
        url("https://lookup.binlist.net/$endpoint")
        return this
    }

    fun getData(url: String, saveCardsInformation: MutableState<SharedPreferences?>): List<CardModel> {

        val gson = GsonBuilder().create()

        val request = Request.Builder()
            .endpoint(url)
            .build()

        val response = client.newCall(request).execute()



        if (response.code < 400) {
            val editor = saveCardsInformation.value?.edit()
            editor?.putString("FirsData", response.body.string())
            editor?.apply()
        }

        return if (response.code > 400) {
            listOf(CardModel(errorHandler = true))

        } else {
            listOf(gson.fromJson(response.body.string(), CardModel::class.java))
        }
    }
}


