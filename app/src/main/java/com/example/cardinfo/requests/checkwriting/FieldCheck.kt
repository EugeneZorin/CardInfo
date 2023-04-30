package com.example.cardinfo.requests.checkwriting

import android.content.Context
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences

class FieldCheck(context: Context) {

    private val requestWriting = RequestWriting(context)
    fun fieldCheck(
        cardNumberRemember: String,
        mainViewModel: MainViewModel,
        preferencesHomeScreenValue: ViewModelSharedPreferences
    ) {

        preferencesHomeScreenValue.saveData(INPUT_VALUE, cardNumberRemember)

        // If the length of the entered value corresponds to one of the numbers,
        // then a new request is sent to get basic or additional data about the map

        // If the value in the input field is lower than 4, then
        // it deletes all information about the map from the screen

        when(cardNumberRemember.length) {
            ConstantValue.THREE -> deleteCardInfo(preferencesHomeScreenValue, mainViewModel)
            ConstantValue.FOUR -> requestWriting.requestWriting(cardNumberRemember, mainViewModel, preferencesHomeScreenValue)
            ConstantValue.EIGHT -> requestWriting.requestWriting(cardNumberRemember, mainViewModel, preferencesHomeScreenValue)
            ConstantValue.TWELVE -> requestWriting.requestWriting(cardNumberRemember, mainViewModel, preferencesHomeScreenValue)
            ConstantValue.SIXTEEN -> requestWriting.requestWriting(cardNumberRemember, mainViewModel, preferencesHomeScreenValue)
        }

    }

    // Deleting card information when the values in the input field are below 4
    private fun deleteCardInfo(
        preferencesHomeScreenValue: ViewModelSharedPreferences,
        mainViewModel: MainViewModel
    ) {
        mainViewModel.infoCardModel.value = listOf(CardModel())
        preferencesHomeScreenValue.deleteData(INPUT_VALUE)
        preferencesHomeScreenValue.deleteData(HOME_SCREEN_VALUES)

    }
}