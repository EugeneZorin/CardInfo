package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.data.constant.ConstantValue.SAVE_SCREEN
import com.example.cardinfo.functions.FormatNumberCard
import com.example.cardinfo.screencomponents.components.CardDataOutputOneColum
import com.example.cardinfo.screencomponents.components.CardDataOutputTwoColum
import com.example.cardinfo.ui.theme.Silver
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel

@Composable
fun InformationSavedScreen(
    counter: String?,
    navController: NavHostController,
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
    mainViewModel: MainViewModel = viewModel(),

) {

    // Calling a class to give the card number the correct look
    val formatNumberCard = FormatNumberCard()

    // Search for card data by saved id
    val allCardInformation = cardDetailsViewModel.gettingInformationCardById(
        counter?.toInt()!!).collectAsState(
        emptyList()
    ).value

    allCardInformation.forEach {

        Box {

            Text(
                text = formatNumberCard.formatNumberCard(it.numberCard),
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

            // Colum with DataCard
            Row(modifier = Modifier
                .fillMaxSize()
                .offset(x = 20.dp, y = 80.dp)) {

                Box (modifier = Modifier
                    .offset(x = 30.dp, y = 50.dp))
                {
                    CardDataOutputOneColum(mainViewModel.outputAdapter(it.allCardDetails))
                }

                Box (modifier = Modifier
                    .offset(x = 100.dp, y = 50.dp))
                {
                    CardDataOutputTwoColum( mainViewModel.outputAdapter(it.allCardDetails))
                }
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