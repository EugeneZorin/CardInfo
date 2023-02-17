package com.example.cardinfo.components.screens.second


import android.content.SharedPreferences
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.cardinfo.SecondActivity


@Composable
fun ButtonBack() {
    val secondActivity = SecondActivity()
    val context = LocalContext.current

    Button(onClick = {
        secondActivity.openMainActivity(context)
    }) {
        Text(text = "Назад", fontSize = 25.sp)
    }
}