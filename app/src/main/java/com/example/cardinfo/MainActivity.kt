package com.example.cardinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.components.CardDataOutputTwoColum
import com.example.cardinfo.components.screens.mainscreen.ButtonOpenSecondScreen
import com.example.cardinfo.components.screens.mainscreen.ButtonSave
import com.example.cardinfo.components.screens.mainscreen.CardDataOutputOneColum
import com.example.cardinfo.components.screens.mainscreen.CardNumberEntry
import com.example.cardinfo.data.constant.ConstantValue.MAIN_DATA
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.functions.SavingStateMainScreen
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel


class MainActivity : ComponentActivity() {

    // Temporarily
    private lateinit var preferencesHomeScreenValue: SharedPreferences
    private val savingStateMainScreen = SavingStateMainScreen()


    private val cardDetailsViewModel: CardDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencesHomeScreenValue = getSharedPreferences(
            MAIN_DATA,
            Context.MODE_PRIVATE
        )

        setContent {
            MainScreen(
                preferencesHomeScreenValue,
                savingStateMainScreen,
                cardDetailsViewModel = cardDetailsViewModel
            )
        }
    }

}

@Composable
fun MainScreen(
    preferencesHomeScreenValue: SharedPreferences,
    savingStateMainScreen: SavingStateMainScreen,
    mainViewModel: MainViewModel = viewModel(),
    cardDetailsViewModel: CardDetailsViewModel

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
            ButtonSave(
                preferencesHomeScreenValue,
                cardDetailsViewModel
            )
        }

        Box(modifier = Modifier
            .offset(x = 70.dp, y = 570.dp))
        {
            ButtonOpenSecondScreen()
        }
    }

}