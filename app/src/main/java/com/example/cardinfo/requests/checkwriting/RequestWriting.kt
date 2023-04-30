package com.example.cardinfo.requests.checkwriting

import android.content.Context
import com.example.cardinfo.requests.okhttp.RequestAdapter
import com.example.cardinfo.requests.okhttp.RequestProcessing
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class RequestWriting(context: Context) {
    private val requestProcessing = RequestProcessing(context)

    private val requestAdapter = RequestAdapter()
    private val requestScope = CoroutineScope(Dispatchers.Default)

    fun requestWriting(
        cardNumberRemember: String,
        mainViewModel: MainViewModel,
        preferencesHomeScreenValue: ViewModelSharedPreferences
    ) {
        // A request is sent to the server to receive information about the card
        requestScope.launch {

            val okHttpData = requestProcessing.getData(cardNumberRemember)

            if (okHttpData != null){

                mainViewModel.responseSaveData.value = listOf(okHttpData)

                mainViewModel.infoCardModel.value = requestAdapter.requestAdapter(
                    mainViewModel,
                    cardNumberRemember,
                    preferencesHomeScreenValue
                )
            }
        }
    }
    fun canselRequest(){
        requestScope.cancel()
    }
}