package com.example.cardinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cardinfo.components.screens.mainscreen.MainScreen
import com.example.cardinfo.data.constant.ConstantValue.MAIN_DATA
import com.example.cardinfo.functions.SavingStateMainScreen
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel


class MainActivity : ComponentActivity() {

    // Temporarily
    private lateinit var preferencesHomeScreenValue: SharedPreferences
    private val savingStateMainScreen = SavingStateMainScreen()


    private val cardDetailsViewModel: CardDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencesHomeScreenValue = getSharedPreferences(
            MAIN_DATA,
            Context.MODE_PRIVATE
        )

        setContent {
            MainScreen(
                preferencesHomeScreenValue,
                savingStateMainScreen,
                cardDetailsViewModel = cardDetailsViewModel
            )
        }
    }

}
