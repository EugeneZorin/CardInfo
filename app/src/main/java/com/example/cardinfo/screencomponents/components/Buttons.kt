package com.example.cardinfo.screencomponents.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.room.CardNumberDetails
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences

@Composable
fun ButtonSave(
    preferencesHomeScreenValue: ViewModelSharedPreferences,
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
) {

     // When you click on the save button, the card data and its number are recorded in the database
    Button(onClick = {

        cardDetailsViewModel.insertDetails(
            CardNumberDetails(null,
                preferencesHomeScreenValue.getData(HOME_SCREEN_VALUES).toString(),
                preferencesHomeScreenValue.getData(INPUT_VALUE).toString(),
            )
        )

    }) {
        Text(text = "Сохранить")
    }
}






