package com.example.cardinfo.functions

import androidx.compose.runtime.MutableState
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue
import com.example.cardinfo.data.constant.ConstantValue.BRACKETS_WITHOUT_SPACES
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodelshared.ViewModelSharedPreferences
import com.google.gson.GsonBuilder

class SavingStateMainScreen {

    fun recordingDisplayedData(
        preferencesHomeScreenValue: ViewModelSharedPreferences,
        mainViewModel: MainViewModel
    ) {
        val gson = GsonBuilder().create()

        val valurCardInfo = mainViewModel.infoCardModel.value

        val key = preferencesHomeScreenValue.getData(HOME_SCREEN_VALUES,)

        if (valurCardInfo.isEmpty() && key != null){
            mainViewModel.infoCardModel.value = listOf(gson.fromJson(key, CardModel::class.java))
        }
    }

    fun checkingKey(
        key: String,
        checkingFirstRequest: MutableState<Boolean>
    ) {
        if (key.length >= ConstantValue.FOUR) {
            checkingFirstRequest.value = true
        }
    }

}