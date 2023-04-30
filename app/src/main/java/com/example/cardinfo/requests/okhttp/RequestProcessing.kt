package com.example.cardinfo.requests.okhttp

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class RequestProcessing(context: Context){

    private val client = OkHttpClient()

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val networkInfo = connectivityManager.activeNetworkInfo
    private val isInternetAvailable = networkInfo?.isConnectedOrConnecting == true

    private fun Request.Builder.endpoint(endpoint: String): Request.Builder {
        url("https://lookup.binlist.net/$endpoint")
        return this
    }

    fun getData(url: String): Response? {

        return if (isInternetAvailable) {
            val request = Request.Builder().endpoint(url).build()
            client.newCall(request).execute()
        } else {
            null
        }
    }
}


