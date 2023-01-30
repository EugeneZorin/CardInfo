package com.example.cardinfo.components.screens.basic

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.cardinfo.MainActivity

@Composable
fun ButtonSave(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Сохранить")
    }
}

@Composable
fun ButtonOpenSecondScreen(){

    val mainActivity = MainActivity()
    val context = LocalContext.current

    Button(onClick = {
        mainActivity.buttonOpenSaveDataCard(context)
    }) {
        Text(text = "Сохраненные номера")
    }
}