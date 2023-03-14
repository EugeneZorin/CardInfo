package com.example.cardinfo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.components.screens.second.ButtonBack
import com.example.cardinfo.components.screens.second.SavedCard
import com.example.cardinfo.functions.MainViewModel
import com.example.cardinfo.functions.SharedPreferencesViewModel

class SecondActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{

            SecondScreen()

        }
    }

    fun openMainActivity(context: Context){
        intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}

@Composable
fun SecondScreen(
    sharedPreferencesViewModel: SharedPreferencesViewModel = viewModel()
) {

    Box(modifier = Modifier
        .height(520.dp)
        .offset(x = 0.dp, y = 15.dp)

    ) {
        LazyColumn(
           modifier = Modifier.fillMaxSize()
        ) {
            items(sharedPreferencesViewModel.sharedPreferencesCardsData.all.size) {
                SavedCard()
            }
        }
    }

    Box(modifier = Modifier
        .offset(x = 145.dp, y = 570.dp)
        .fillMaxSize())
    {
        ButtonBack()
    }
}

