package com.example.cardinfo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.components.*
import com.example.cardinfo.components.screens.basic.ButtonOpenSecondScreen
import com.example.cardinfo.components.screens.basic.ButtonSave
import com.example.cardinfo.components.screens.basic.CardDataOutputOneColum
import com.example.cardinfo.components.screens.basic.CardNumberEntry
import com.example.cardinfo.data.ConstantValue.MAIN_DATA
import com.example.cardinfo.data.ConstantValue.OTHER_SCREEN_VALUES
import com.example.cardinfo.data.ConstantValue.SAVE_DATA
import com.example.cardinfo.functions.MainViewModel
import com.example.cardinfo.functions.SavingStateMainScreen


class MainActivity : ComponentActivity() {


    // Temporarily
    private lateinit var preferencesHomeScreenValue: SharedPreferences
    private lateinit var preferencesOtherScreenValue: SharedPreferences
    private val savingStateMainScreen = SavingStateMainScreen()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        preferencesHomeScreenValue = getSharedPreferences(
            MAIN_DATA,
            Context.MODE_PRIVATE
        )

        // Temporarily
        preferencesOtherScreenValue = getSharedPreferences(
            SAVE_DATA, Context.MODE_PRIVATE
        )


        setContent {
            MainScreen(
                preferencesHomeScreenValue,
                savingStateMainScreen,
                preferencesOtherScreenValue
            )
        }
    }


    fun buttonOpenSaveDataCard(context: Context, preferencesOtherScreenValue: SharedPreferences) {
       intent = Intent(context, SecondActivity::class.java)
        // Temporarily
       intent.putExtra("key1", preferencesOtherScreenValue.getString(OTHER_SCREEN_VALUES, null))
       context.startActivity(intent)
    }


}



@Composable
fun MainScreen(
    preferencesHomeScreenValue: SharedPreferences,
    savingStateMainScreen: SavingStateMainScreen,
    preferencesOtherScreenValue: SharedPreferences,
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
            ButtonSave(
                preferencesHomeScreenValue,
                savingStateMainScreen,
                preferencesOtherScreenValue

            )
        }

        Box(modifier = Modifier
            .offset(x = 70.dp, y = 570.dp))
        {
            ButtonOpenSecondScreen(preferencesOtherScreenValue)
        }
    }

}