package com.example.cardinfo.requests.okhttp

import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.ERROR_FOUR_HUNDRED
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences
import com.google.gson.GsonBuilder

class RequestAdapter {

    fun requestAdapter(
        mainViewModel: MainViewModel,
        cardNumberRemember: String,
        preferencesHomeScreenValue: ViewModelSharedPreferences
    ): List<CardModel> {

        val gson = GsonBuilder().create()

        val response = mainViewModel.responseSaveData.value[0].body.string()
        val responseCode = mainViewModel.responseSaveData.value[0].code

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