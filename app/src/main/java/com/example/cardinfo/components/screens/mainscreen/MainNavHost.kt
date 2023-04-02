package com.example.cardinfo.components.screens.mainscreen

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.components.screens.savescreen.SaveScreen
import com.example.cardinfo.functions.SavingStateMainScreen

@Composable
fun MainNavHost(
    preferencesHomeScreenValue: SharedPreferences,
    savingStateMainScreen: SavingStateMainScreen
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainScreen" ){
        composable("MainScreen") {
            MainScreen(
                preferencesHomeScreenValue = preferencesHomeScreenValue,
                savingStateMainScreen = savingStateMainScreen,
                navController = navController)
        }

        composable("SaveScreen") {
            SaveScreen()
        }
    }


}