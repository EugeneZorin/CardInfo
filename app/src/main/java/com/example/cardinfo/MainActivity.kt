package com.example.cardinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cardinfo.components.screens.mainscreen.MainScreen
import com.example.cardinfo.components.screens.mainscreen.components.NavButton
import com.example.cardinfo.data.constant.ConstantValue.MAIN_DATA
import com.example.cardinfo.functions.SavingStateMainScreen


class MainActivity : ComponentActivity() {

    // Temporarily
    private lateinit var preferencesHomeScreenValue: SharedPreferences
    private val savingStateMainScreen = SavingStateMainScreen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencesHomeScreenValue = getSharedPreferences(
            MAIN_DATA,
            Context.MODE_PRIVATE
        )

        setContent {
            NavButton(
                preferencesHomeScreenValue,
                savingStateMainScreen
            )
        }
    }

}
