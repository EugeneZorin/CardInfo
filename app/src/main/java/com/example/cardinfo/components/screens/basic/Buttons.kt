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
import com.example.cardinfo.functions.SharedPreferencesViewModel

@Composable
fun ButtonSave(
    preferencesHomeScreenValue: SharedPreferences,
    sharedPreferencesViewModel: SharedPreferencesViewModel = viewModel()
) {

    Button(onClick = {
        preferencesHomeScreenValue.getString(HOME_SCREEN_VALUES, null)
            ?.let { sharedPreferencesViewModel.saveCardsData(it) }

    }) {
        Text(text = "Сохранить")
    }
}

@Composable
fun ButtonOpenSecondScreen() {

    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, SecondActivity::class.java)
        context.startActivity(intent)



    }) {
        Text(text = "Сохраненные номера")
    }
}




