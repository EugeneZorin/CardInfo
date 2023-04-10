package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.ONE
import com.example.cardinfo.screencomponents.components.CardDataOutputOneColum
import com.example.cardinfo.screencomponents.components.CardDataOutputTwoColum
import com.example.cardinfo.screencomponents.components.CardNumberEntry
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import com.google.gson.GsonBuilder

@Composable
fun InformationSavedScreen(
    counter: String?,
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
    mainViewModel: MainViewModel = viewModel(),
) {

    val id = counter?.toInt()?.minus(ONE)
    val userDao = cardDetailsViewModel.allDetails.observeAsState(emptyList()).value

    if(userDao.isNotEmpty()){
        mainViewModel.infoCardModel.value = listOf(GsonBuilder()
            .create()
            .fromJson(userDao[id!!].numberCard, CardModel::class.java))
    }

    if (userDao.isNotEmpty()){
        Box (modifier = Modifier
            .offset(x = 80.dp, y = 20.dp)
            .fillMaxSize())
        {
            Text(
                text = userDao[id!!].DetailsCard,
                fontSize = 40.sp
            )
        }
    }

    // Colum with DataCard
    Row(modifier = Modifier
        .fillMaxSize()
        .offset(x = 20.dp, y = 50.dp)) {

        Box (modifier = Modifier
            .offset(x = 5.dp, y = 50.dp))
        {
            CardDataOutputOneColum(mainViewModel.infoCardModel) }

        Box (modifier = Modifier
            .offset(x = 95.dp, y = 50.dp))
        {
            CardDataOutputTwoColum(mainViewModel.infoCardModel) }
    }







    







}