package com.example.cardinfo.components.screens.savescreen.components


import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.cardinfo.SaveActivity


@Composable
fun ButtonBack() {
    val saveActivity = SaveActivity()
    val context = LocalContext.current

    Button(onClick = {
        saveActivity.openMainActivity(context)
    }) {
        Text(text = "Назад", fontSize = 25.sp)
    }
}