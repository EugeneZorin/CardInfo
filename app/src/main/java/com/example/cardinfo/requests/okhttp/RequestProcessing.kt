package com.example.cardinfo.requests.okhttp

import okhttp3.*


class RequestProcessing(){

    private val client = OkHttpClient()

    private fun Request.Builder.endpoint(endpoint: String): Request.Builder {
        url("https://lookup.binlist.net/$endpoint")
        return this
    }

    fun getData(url: String): Response {

        val request = Request.Builder()
            .endpoint(url)
            .build()


        return client.newCall(request).execute()
    }
}


