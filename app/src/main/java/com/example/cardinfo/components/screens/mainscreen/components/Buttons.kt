package com.example.cardinfo.components.screens.mainscreen.components

import android.content.Intent
import android.content.SharedPreferences
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.cardinfo.SaveActivity
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.room.CardNumberDetails
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel

@Composable
fun ButtonSave(
    preferencesHomeScreenValue: SharedPreferences,
    cardDetailsViewModel: CardDetailsViewModel,
) {

     // When you click on the save button, the card data and its number are recorded in the database
    Button(onClick = {

        cardDetailsViewModel.insertDetails(
            CardNumberDetails(null,
            preferencesHomeScreenValue.getString(HOME_SCREEN_VALUES, null).toString(),
            preferencesHomeScreenValue.getString(INPUT_VALUE, null).toString()
            )
        )

    }) {
        Text(text = "Сохранить")
    }
}

@Composable
fun ButtonOpenSecondScreen() {

    val context = LocalContext.current

    Button(onClick = {

        val intent = Intent(context, SaveActivity::class.java)
        context.startActivity(intent)

    }) {
        Text(text = "Сохраненные номера")
    }
}




