package com.example.cardinfo.components.screens.mainscreen.components

import android.content.SharedPreferences
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.components.screens.mainscreen.MainScreen
import com.example.cardinfo.components.screens.savescreen.SaveScreen
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.functions.SavingStateMainScreen
import com.example.cardinfo.room.CardNumberDetails
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel


@Composable
fun ButtonSave(
    preferencesHomeScreenValue: SharedPreferences,
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
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






