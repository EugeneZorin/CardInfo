package com.example.cardinfo.functions

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import com.example.cardinfo.data.ConstantValue.SHARED_PREFERENCES_CARDS_DATA

class SharedPreferencesViewModel(application: Application) : AndroidViewModel(application) {

    val sharedPreferencesCardsData: SharedPreferences = application.getSharedPreferences(SHARED_PREFERENCES_CARDS_DATA, Context.MODE_PRIVATE)

    fun saveCardsData(cardInfo: String){
        val count = sharedPreferencesCardsData.all.size
        with(sharedPreferencesCardsData.edit()) {
            putString((count + 1).toString(), cardInfo)
            apply()
        }
    }
}