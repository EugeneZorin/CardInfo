package com.example.cardinfo.functions

import com.example.cardinfo.data.constant.ConstantValue
import com.example.cardinfo.room.CardDetails
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CheckingMatches {

    fun checkingMatches(
        preferencesHomeScreenValue: ViewModelSharedPreferences,
        cardDetailsViewModel: CardDetailsViewModel
    ){

        val saveScope = CoroutineScope(Dispatchers.Default)

        saveScope.launch {

            // Request-entered number is sent to the database, if the response is null,
            // then this value is not in the database.
            // And if the card number is returned, then the value is in the database and it is not recorded.
            val checkingValueExists  = cardDetailsViewModel
                .gettingInformationCardNumber(
                    preferencesHomeScreenValue.getData(ConstantValue.INPUT_VALUE)
                        .toString())
                .first()

            if (checkingValueExists.isNullOrBlank()){
                cardDetailsViewModel.insertDetails(
                    CardDetails(
                        null,
                        preferencesHomeScreenValue.getData(ConstantValue.HOME_SCREEN_VALUES).toString(),
                        preferencesHomeScreenValue.getData(ConstantValue.INPUT_VALUE).toString(),
                    )
                )
            }
        }
    }
}