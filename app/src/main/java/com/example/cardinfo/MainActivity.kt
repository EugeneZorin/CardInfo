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
import android.content.SharedPreferences
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.components.screens.basic.CardDataOutputOneColum
import com.example.cardinfo.components.screens.basic.CardNumberEntry
import com.example.cardinfo.data.ConstantValue.MAIN_DATA
import com.example.cardinfo.functions.MainViewModel
import com.example.cardinfo.functions.SavingStateMainScreen


class MainActivity : ComponentActivity() {

    private lateinit var preferencesHomeScreenValue: SharedPreferences
    private val savingStateMainScreen = SavingStateMainScreen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencesHomeScreenValue = getSharedPreferences(
            MAIN_DATA,
            Context.MODE_PRIVATE
        )

        setContent {
            MainScreen(
                preferencesHomeScreenValue,
                savingStateMainScreen
            )
        }
    }

    fun buttonOpenSaveDataCard(context: Context) {
       intent = Intent(context, SecondActivity::class.java)
       context.startActivity(intent)
    }

}



@Composable
fun MainScreen(
    preferencesHomeScreenValue: SharedPreferences,
    savingStateMainScreen: SavingStateMainScreen,
    mainViewModel: MainViewModel = viewModel()
) {

    // Write mapped data to storage
    savingStateMainScreen.recordingDisplayedData(
        preferencesHomeScreenValue,
        mainViewModel
    )


    Box (modifier = Modifier
        .offset(x = 50.dp, y = 20.dp)
        .fillMaxSize())
    {
        CardNumberEntry(
            mainViewModel.infoCardModel,
            mainViewModel.characterLimitSubmittingRequest,
            cardNumber = mainViewModel.cardNumber,
            checkingFirstRequest = mainViewModel.checkingFirstRequest,
            mainViewModel.responseSaveData,
            preferencesHomeScreenValue
        )

    }

    // Colum with DataCard
    Row(modifier = Modifier
        .offset(x = 30.dp, y = 50.dp)) {

        Box (modifier = Modifier
            .offset(x = 5.dp, y = 50.dp))
        {
            CardDataOutputOneColum(mainViewModel.infoCardModel) }

        Box (modifier = Modifier
            .offset(x = 95.dp, y = 50.dp))
        {
            CardDataOutputTwoColum(mainViewModel.infoCardModel) }

    }

    // Buttons
    Row(modifier = Modifier
        .offset(x = 0.dp, y = 0.dp)
        .fillMaxSize()) {

        Box(modifier = Modifier
            .offset(x = 30.dp, y = 570.dp))
        {
            ButtonSave()
        }

        Box(modifier = Modifier
            .offset(x = 70.dp, y = 570.dp))
        {
            ButtonOpenSecondScreen()
        }
    }

}