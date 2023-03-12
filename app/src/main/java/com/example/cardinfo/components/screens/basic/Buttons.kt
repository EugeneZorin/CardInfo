package com.example.cardinfo.components.screens.basic

import android.content.Intent
import android.content.SharedPreferences
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.SecondActivity
import com.example.cardinfo.data.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.ConstantValue.OTHER_SCREEN_VALUES
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
        val count = preferencesOtherScreenValue.all.size
        preferencesOtherScreenValue.edit().putString((count + 1).toString(), saveInfoCard).apply()

    }) {
        Text(text = "Сохранить")
    }
}

@Composable
fun ButtonOpenSecondScreen(preferencesOtherScreenValue: SharedPreferences) {

    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("key1", preferencesOtherScreenValue.getString(OTHER_SCREEN_VALUES, null))
        context.startActivity(intent)



    }) {
        Text(text = "Сохраненные номера")
    }
}




