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
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.functions.MainViewModel
import com.example.cardinfo.requests.RequestAdapter
import com.google.gson.GsonBuilder

const val MAIN_SCREEN = "MAIN_SCREEN"
const val DATA_TEST_VALUE = "DATA_TEST_VALUE"

class MainActivity : ComponentActivity() {

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = getSharedPreferences(MAIN_SCREEN, Context.MODE_PRIVATE)

        setContent {
            MainScreen(preferences)
        }
    }

    fun buttonOpenSaveDataCard(context: Context) {
       intent = Intent(context, SecondActivity::class.java)
       context.startActivity(intent)
    }
}



@Composable
fun MainScreen(
    preferences: SharedPreferences,
    mainViewModel: MainViewModel = viewModel()

) {
    val gson = GsonBuilder().create()
    val key = preferences.getString(DATA_TEST_VALUE, "")
    mainViewModel.cardInfoCardModel.value = listOf(gson.fromJson(key, CardModel::class.java))



    Box (modifier = Modifier
        .offset(x = 50.dp, y = 20.dp)
        .fillMaxSize())
    {
        CardNumberEntry(
            mainViewModel.cardInfoCardModel,
            mainViewModel.characterLimitSubmittingRequest,
            cardNumber = mainViewModel.cardNumber,
            checkingFirstRequest = mainViewModel.checkingFirstRequest,
            pattern = mainViewModel.pattern,
            mainViewModel.responseSaveData,
            preferences
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
            ButtonOpenSecondScreen()
        }
    }

}