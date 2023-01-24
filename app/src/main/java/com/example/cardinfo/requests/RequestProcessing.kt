package com.example.cardinfo.requests

import com.example.cardinfo.data.CardModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Response


class RequestProcessing() {

    private val client = OkHttpClient()
    private lateinit var response: Response

    fun getData(url: String): List<CardModel> {

        val request = okhttp3.Request.Builder()
            .url("https://lookup.binlist.net/$url")
            .build()

        response = client.newCall(request).execute()
        val requestCard = response.body.string()

        val gson = GsonBuilder().create()

        return listOf(gson.fromJson(requestCard, CardModel::class.java))

    }
}