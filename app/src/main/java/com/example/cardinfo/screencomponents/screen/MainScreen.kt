package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.data.constant.ConstantValue.SAVE_SCREEN
import com.example.cardinfo.functions.CheckingMatches
import com.example.cardinfo.screencomponents.components.CardDataOutputOneColum
import com.example.cardinfo.screencomponents.components.CardDataOutputTwoColum
import com.example.cardinfo.screencomponents.components.CardNumberEntry
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = viewModel(),
    preferencesHomeScreenData: ViewModelSharedPreferences = viewModel(),
    cardDetailsViewModel: CardDetailsViewModel = viewModel()
) {

    val checkingMatches = CheckingMatches()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .offset(y = 50.dp),
            contentAlignment = Alignment.Center
        ) {

            CardNumberEntry()

            if (mainViewModel.checkingMessageError.value) ErrorMessages()
            if (mainViewModel.noInternetMessage.value) NoInternetMessages()
        }


        Row(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 50.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(40.dp)
                    .weight(1f),
                contentAlignment = Alignment.TopStart
            ) {
                CardDataOutputOneColum(mainViewModel.infoCardModel)
            }

            Box(
                modifier = Modifier
                    .padding(40.dp)
                    .weight(1f),
                contentAlignment = Alignment.TopEnd
            ) {
                CardDataOutputTwoColum(mainViewModel.infoCardModel)
            }
        }
    }


    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp, horizontal = 0.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {

        Button(
            onClick = {
                navController.navigate(SAVE_SCREEN)
            },
            modifier = Modifier
                .padding(2.dp)
                .width(200.dp)
                .height(41.dp)
        ) {
            Text(
                text = "Сохраненные номера",
                fontSize = 12.sp
            )
        }

        Button(
            onClick = {
                checkingMatches.checkingMatches(
                    preferencesHomeScreenData,
                    cardDetailsViewModel,
                    mainViewModel
            )},
            modifier = Modifier
                .padding(2.dp)
                .width(130.dp)
                .height(41.dp)
        ) {
            Text(
                text = "Сохранить"
            )
        }
    }
}

@Composable
fun ErrorMessages(
    mainViewModel: MainViewModel = viewModel()
) {

    Text(
        text = "этот номер уже сохранен",
        color = Color.Red,
        modifier = Modifier
            .offset(y = 37.dp),
        textAlign = TextAlign.Center
    )

    LaunchedEffect(Unit){
        delay(2500)
        mainViewModel.checkingMessageError.value = false
    }
}


@Composable
fun NoInternetMessages(
    mainViewModel: MainViewModel = viewModel()
){
    Text(
        text = "отсутствует подключения к интернету",
        color = Color.Red,
        modifier = Modifier
            .offset(y = 37.dp),
        textAlign = TextAlign.Center
    )

    LaunchedEffect(Unit){
        delay(5000)
        mainViewModel.noInternetMessage.value = false
    }
}

