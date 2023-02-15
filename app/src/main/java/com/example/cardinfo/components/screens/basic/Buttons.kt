package com.example.cardinfo.components.screens.basic

import android.content.SharedPreferences
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import com.example.cardinfo.DATA_TEST_VALUE
import com.example.cardinfo.MainActivity
import com.example.cardinfo.data.CardModel

@Composable
fun ButtonSave(cardInfoCardModel: MutableState<List<CardModel>>) {
    Button(onClick = {


    }) {
        Text(text = "Сохранить")
    }
}

@Composable
fun ButtonOpenSecondScreen() {

    val mainActivity = MainActivity()
    val context = LocalContext.current


    Button(onClick = {
        mainActivity.buttonOpenSaveDataCard(context)

    }) {
        Text(text = "Сохраненные номера")
    }
}