package com.example.cardinfo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinfo.components.*
import com.example.cardinfo.components.screens.basic.ButtonOpenSecondScreen
import com.example.cardinfo.components.screens.basic.ButtonSave
import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.ui.theme.MainViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }

    fun buttonOpenSaveDataCard(context: Context) {
       intent = Intent(context, SecondActivity::class.java)
       context.startActivity(intent)
    }
}



@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel()
) {

    Box (modifier = Modifier
        .offset(x = 50.dp, y = 20.dp)
        .fillMaxSize())
    {
        CardNumberEntry(
            mainViewModel.cardInfoCardModel,
            mainViewModel.characterLimitSubmittingRequest,
            cardNumber = mainViewModel.cardNumber,
            updateCardNumber = {mainViewModel.updateCardNumber(it)},
            checkingFirstRequest = mainViewModel.checkingFirstRequest,
            pattern = mainViewModel.pattern
        )

    }

    // Colum with DataCard
    Row(modifier = Modifier
        .offset(x = 30.dp, y = 50.dp)) {

        Box (modifier = Modifier
            .offset(x = 5.dp, y = 50.dp))
        {
            CardDataOutputOneColum(mainViewModel.cardInfoCardModel) }

        Box (modifier = Modifier
            .offset(x = 95.dp, y = 50.dp))
        {
            CardDataOutputTwoColum(mainViewModel.cardInfoCardModel) }

    }

    // Buttons
    Row(modifier = Modifier
        .offset(x = 0.dp, y = 0.dp)
        .fillMaxSize()) {

        Box(modifier = Modifier
            .offset(x = 30.dp, y = 570.dp))
        {
            ButtonSave(mainViewModel.cardInfoCardModel)
        }

        Box(modifier = Modifier
            .offset(x = 70.dp, y = 570.dp))
        {
            ButtonOpenSecondScreen(mainViewModel.cardInfoCardModel)
        }
    }
}