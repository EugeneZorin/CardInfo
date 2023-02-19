package com.example.cardinfo.components.screens.basic

import android.content.SharedPreferences
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.MainActivity
import com.example.cardinfo.data.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.ConstantValue.OTHER_SCREEN_VALUES
import com.example.cardinfo.data.ConstantValue.SAVE_DATA
import com.example.cardinfo.functions.MainViewModel
import com.example.cardinfo.functions.SavingStateMainScreen

@Composable
fun ButtonSave(
    preferencesHomeScreenValue: SharedPreferences,
    savingStateMainScreen: SavingStateMainScreen,
    preferencesOtherScreenValue: SharedPreferences,
    mainViewModel: MainViewModel = viewModel()
) {

    // Temporarily
    val saveInfoCard = preferencesHomeScreenValue.getString(HOME_SCREEN_VALUES, null)

    Button(onClick = {
        preferencesOtherScreenValue.edit().putString(OTHER_SCREEN_VALUES, saveInfoCard).apply()
    }) {
        Text(text = "Сохранить")
    }
}

@Composable
fun ButtonOpenSecondScreen(preferencesOtherScreenValue: SharedPreferences) {

    val mainActivity = MainActivity()
    val context = LocalContext.current


    Button(onClick = {
        mainActivity.buttonOpenSaveDataCard(context, preferencesOtherScreenValue)

    }) {
        Text(text = "Сохраненные номера")
    }
}