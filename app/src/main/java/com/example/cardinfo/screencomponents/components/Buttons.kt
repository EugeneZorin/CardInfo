package com.example.cardinfo.screencomponents.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.room.CardDetails
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun ButtonSave(
    preferencesHomeScreenValue: ViewModelSharedPreferences,
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
) {

    val saveScope = CoroutineScope(Dispatchers.Default)

     // When you click on the save button, the card data and its number are recorded in the database
    Button(onClick = {

        saveScope.launch {

            // Request-entered number is sent to the database, if the response is null,
            // then this value is not in the database.
            // And if the card number is returned, then the value is in the database and it is not recorded.
            val checkingValueExists  = cardDetailsViewModel
                .gettingInformationCardNumber(
                    preferencesHomeScreenValue.getData(INPUT_VALUE)
                    .toString())
                .first()

            if (checkingValueExists.isNullOrBlank()){
                cardDetailsViewModel.insertDetails(
                    CardDetails(
                        null,
                        preferencesHomeScreenValue.getData(HOME_SCREEN_VALUES).toString(),
                        preferencesHomeScreenValue.getData(INPUT_VALUE).toString(),
                    )
                )
            }
        }

    }) {
        Text(text = "Сохранить")
    }
}






