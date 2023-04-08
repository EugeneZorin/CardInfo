package com.example.cardinfo.requests.checkwriting

import com.example.cardinfo.requests.okhttp.RequestAdapter
import com.example.cardinfo.requests.okhttp.RequestProcessing
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class RequestWriting(){

    private val requestProcessing = RequestProcessing()
    private val requestAdapter = RequestAdapter()
    private val requestScope = CoroutineScope(Dispatchers.Default)

    fun requestWriting(
        cardNumberRemember: String,
        mainViewModel: MainViewModel,
        preferencesHomeScreenValue: ViewModelSharedPreferences
    ) {
        // A request is sent to the server to receive information about the card
        requestScope.launch {
            mainViewModel.responseSaveData.value = listOf(requestProcessing.getData(cardNumberRemember))

            mainViewModel.infoCardModel.value = requestAdapter.requestAdapter(
                mainViewModel,
                cardNumberRemember,
                preferencesHomeScreenValue
            )
        }
    }
    fun canselRequest(){
        requestScope.cancel()
    }
}