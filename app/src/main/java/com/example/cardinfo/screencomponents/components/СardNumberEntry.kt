package com.example.cardinfo.screencomponents.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.functions.EnteringValue
import com.example.cardinfo.requests.checkwriting.FieldCheck
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences

// fields for entering the card number
@Composable
fun CardNumberEntry(
    mainViewModel: MainViewModel = viewModel(),
    preferencesHomeScreenValue: ViewModelSharedPreferences = viewModel()
) {

    var cardNumberRemember by rememberSaveable() { mutableStateOf("") }
    val fieldCheck = FieldCheck()
    val enteringValue = EnteringValue()

    OutlinedTextField(
        value = cardNumberRemember,
        onValueChange = {

            cardNumberRemember = it

            fieldCheck.fieldCheck(cardNumberRemember, mainViewModel, preferencesHomeScreenValue)

        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),


        // Filter for entering the card number with a space every 4 digits
        visualTransformation = { enteringValue.filter(it) },

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White
        )
    )
}


