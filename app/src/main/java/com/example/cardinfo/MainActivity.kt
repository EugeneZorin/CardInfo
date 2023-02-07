package com.example.cardinfo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinfo.components.*
import com.example.cardinfo.components.screens.basic.ButtonOpenSecondScreen
import com.example.cardinfo.components.screens.basic.ButtonSave
import com.example.cardinfo.data.CardModel
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import com.example.cardinfo.functions.CardsDataSave


class MainActivity : ComponentActivity() {


    private val cardsDataSave = CardsDataSave()
    private var cardsInformation: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cardsInformation = getSharedPreferences("CardsData", Context.MODE_PRIVATE)

        setContent {

            val saveCardsInformation = remember  {
                mutableStateOf(cardsInformation)
            }


            val cardInfoCardModel = remember {
                mutableStateOf(listOf<CardModel>())
            }

            // The number of characters after which the request is sent
            val characterLimitSubmittingRequest = remember {
                mutableStateOf(4)
            }

            MainScreen(cardInfoCardModel, characterLimitSubmittingRequest, saveCardsInformation)
            cardsDataSave.cardDataSave(saveCardsInformation, cardInfoCardModel)

        }
    }


    fun buttonOpenSaveDataCard(context: Context) {
       intent = Intent(context, SecondActivity::class.java)
       context.startActivity(intent)
    }
}



@Composable
fun MainScreen(
    cardInfoCardModel: MutableState<List<CardModel>>,
    characterLimitSubmittingRequest: MutableState<Int>,
    saveCardsInformation: MutableState<SharedPreferences?>
) {

    Box (modifier = Modifier
        .offset(x = 50.dp, y = 20.dp)
        .fillMaxSize())
    {
        CardNumberEntry(cardInfoCardModel, saveCardsInformation, characterLimitSubmittingRequest)
    }

    // Colum with DataCard
    Row(modifier = Modifier
        .offset(x = 30.dp, y = 50.dp)) {

        Box (modifier = Modifier
            .offset(x = 5.dp, y = 50.dp))
        {
            CardDataOutputOneColum(cardInfoCardModel) }

        Box (modifier = Modifier
            .offset(x = 95.dp, y = 50.dp))
        {
            CardDataOutputTwoColum(cardInfoCardModel) }

    }

    // Buttons
    Row(modifier = Modifier
        .offset(x = 0.dp, y = 0.dp)
        .fillMaxSize()) {

        Box(modifier = Modifier
            .offset(x = 30.dp, y = 570.dp))
        {
            ButtonSave(cardInfoCardModel)
        }

        Box(modifier = Modifier
            .offset(x = 70.dp, y = 570.dp))
        {
            ButtonOpenSecondScreen(cardInfoCardModel)
        }
    }
}