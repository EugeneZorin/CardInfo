package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.ONE
import com.example.cardinfo.data.constant.ConstantValue.SAVE_SCREEN
import com.example.cardinfo.functions.FormatNumberCard
import com.example.cardinfo.screencomponents.components.CardDataOutputOneColum
import com.example.cardinfo.screencomponents.components.CardDataOutputTwoColum
import com.example.cardinfo.ui.theme.Silver
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import com.google.gson.GsonBuilder

@Composable
fun InformationSavedScreen(
    counter: String?,
    navController: NavHostController,
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
    mainViewModel: MainViewModel = viewModel(),

) {

    val formatNumberCard = FormatNumberCard()

    val id = counter?.toInt()?.minus(ONE)
    val userDao = cardDetailsViewModel.allDetails.observeAsState(emptyList()).value

    Box {

        if (userDao.isNotEmpty()){
            Text(
                text = formatNumberCard.formatNumberCard(userDao[id!!].DetailsCard),
                style = TextStyle(
                    color = Silver,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .offset(y = 40.dp),
                textAlign = TextAlign.Center,
            )
        }

        // Colum with DataCard
        Row(modifier = Modifier
            .fillMaxSize()
            .offset(x = 20.dp, y = 80.dp)) {

            Box (modifier = Modifier
                .offset(x = 30.dp, y = 50.dp))
            {
                CardDataOutputOneColum(mainViewModel.outputAdapter(userDao, id))
            }

            Box (modifier = Modifier
                .offset(x = 100.dp, y = 50.dp))
            {
                CardDataOutputTwoColum( mainViewModel.outputAdapter(userDao, id))
            }
        }

        Box(modifier = Modifier
            .offset(x = 125.dp, y = 570.dp)
            .fillMaxSize()
        ) {
            Button(
                onClick = { navController.navigate(SAVE_SCREEN) },
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .padding(2.dp)
            ) {
                Text(text = "Назад")
            }
        }

    }

}