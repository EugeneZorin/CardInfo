package com.example.cardinfo.functions

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import com.example.cardinfo.data.ConstantValue.SHARED_PREFERENCES_CARDS_DATA
import com.example.cardinfo.data.ConstantValue.SHARED_PREFERENCES_NUMBER_CARD

class SharedPreferencesViewModel(application: Application) : AndroidViewModel(application) {

    val sharedPreferencesCardsData: SharedPreferences = application.getSharedPreferences(
        SHARED_PREFERENCES_CARDS_DATA,
        Context.MODE_PRIVATE
    )

    val sharedPreferencesNumberCard: SharedPreferences = application.getSharedPreferences(
        SHARED_PREFERENCES_NUMBER_CARD,
        Context.MODE_PRIVATE
    )

    private val count = sharedPreferencesCardsData.all.size
    fun saveCardsData(cardInfo: String){

        with(sharedPreferencesCardsData.edit()) {
            putString((count + 1).toString(), cardInfo)
            apply()
        }
    }

    fun saveNumberCards(numberCard: String){
        with(sharedPreferencesNumberCard.edit()){
            putString(count.toString(), numberCard)
            apply()
        }
    }


}