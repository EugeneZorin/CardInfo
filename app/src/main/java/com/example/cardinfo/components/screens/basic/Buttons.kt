package com.example.cardinfo.components.screens.basic

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.MainActivity
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.functions.MainViewModel

@Composable
fun ButtonSave(cardInfoCardModel: MutableState<List<CardModel>>) {
    Button(onClick = {


    }) {
        Text(text = "Сохранить")
    }
}

@Composable
fun ButtonOpenSecondScreen(mainViewModel: MainViewModel = viewModel()) {

    val mainActivity = MainActivity()
    val context = LocalContext.current


    Button(onClick = {
        mainActivity.saveData(mainViewModel.cardInfoCardModel.value[0].toString())
        mainActivity.buttonOpenSaveDataCard(context)

    }) {
        Text(text = "Сохраненные номера")
    }
}