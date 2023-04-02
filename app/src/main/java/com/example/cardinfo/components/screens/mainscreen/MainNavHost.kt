package com.example.cardinfo.components.screens.mainscreen

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.components.screens.savescreen.SaveScreen
import com.example.cardinfo.functions.SavingStateMainScreen

@Composable
fun MainNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainScreen" ){
        composable("MainScreen") {
            MainScreen(
                navController = navController
            )
        }

        composable("SaveScreen") {
            SaveScreen()
        }
    }


}