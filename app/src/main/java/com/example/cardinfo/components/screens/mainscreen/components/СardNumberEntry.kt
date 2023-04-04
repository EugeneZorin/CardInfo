package com.example.cardinfo.components.screens.mainscreen.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.data.constant.ConstantValue.FOUR
import com.example.cardinfo.requests.checkwriting.FieldCheck
import com.example.cardinfo.requests.checkwriting.RequestWriting
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

// fields for entering the card number
@Composable
fun CardNumberEntry(
    mainViewModel: MainViewModel = viewModel(),
    preferencesHomeScreenValue: ViewModelSharedPreferences = viewModel()
) {

    var cardNumberRemember by rememberSaveable() { mutableStateOf(mainViewModel.cardNumber) }
    val fieldCheck = FieldCheck()

    OutlinedTextField(
        value = cardNumberRemember ,
        onValueChange = {

            cardNumberRemember = it

            fieldCheck.fieldCheck(
                cardNumberRemember,
                mainViewModel,
                preferencesHomeScreenValue
            )
        },

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White
        )
    )
}


