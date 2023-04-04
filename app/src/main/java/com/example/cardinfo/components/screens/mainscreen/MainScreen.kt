package com.example.cardinfo.components.screens.mainscreen

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
import com.example.cardinfo.components.screens.mainscreen.components.*
import com.example.cardinfo.functions.SavingStateMainScreen
import com.example.cardinfo.viewmodels.MainViewModel
import com.example.cardinfo.viewmodelshared.ViewModelSharedPreferences

@Composable
fun MainScreen(
    savingStateMainScreen: SavingStateMainScreen = SavingStateMainScreen(),
    navController: NavHostController,
    mainViewModel: MainViewModel = viewModel(),
    preferencesHomeScreenData: ViewModelSharedPreferences = viewModel()

) {

    // Write mapped data to storage
    savingStateMainScreen.recordingDisplayedData(
        preferencesHomeScreenData,
        mainViewModel
    )


    Box (modifier = Modifier
        .offset(x = 50.dp, y = 20.dp)
        .fillMaxSize())
    {
        CardNumberEntry()
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
            Button(onClick = { navController.navigate("SaveScreen") }) {
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