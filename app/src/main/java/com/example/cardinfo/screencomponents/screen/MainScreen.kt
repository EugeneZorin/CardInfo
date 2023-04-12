package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.data.constant.ConstantValue.SAVE_SCREEN
import com.example.cardinfo.screencomponents.components.ButtonSave
import com.example.cardinfo.screencomponents.components.CardDataOutputOneColum
import com.example.cardinfo.screencomponents.components.CardDataOutputTwoColum
import com.example.cardinfo.screencomponents.components.CardNumberEntry
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = viewModel(),
    preferencesHomeScreenData: ViewModelSharedPreferences = viewModel()
) {

    Box (modifier = Modifier
        .offset(x = 50.dp, y = 20.dp)
        .fillMaxSize())
    {
        CardNumberEntry()
    }

    // Colum with DataCard
    Row(modifier = Modifier
        .offset(x = 20.dp, y = 50.dp)) {

        Box (modifier = Modifier
            .offset(x = 30.dp, y = 50.dp))
        {
            CardDataOutputOneColum(mainViewModel.infoCardModel) }

        Box (modifier = Modifier
            .offset(x = 100.dp, y = 50.dp))
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
            Button(onClick = { navController.navigate(SAVE_SCREEN) }) {
                Text(text = "Сохраненные номера")
            }
        }

        Box(modifier = Modifier
            .offset(x = 70.dp, y = 570.dp))
        {
            ButtonSave(preferencesHomeScreenData)
        }
    }
}