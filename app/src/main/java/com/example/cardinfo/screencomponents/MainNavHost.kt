package com.example.cardinfo.screencomponents

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.data.constant.ConstantValue.INFORMATION_SAVED_SCREEN
import com.example.cardinfo.data.constant.ConstantValue.MAIN_SCREEN
import com.example.cardinfo.data.constant.ConstantValue.SAVE_SCREEN
import com.example.cardinfo.screencomponents.screen.InformationSavedScreen
import com.example.cardinfo.screencomponents.screen.MainScreen
import com.example.cardinfo.screencomponents.screen.SaveScreen


@Composable
fun MainNavHost() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN
    ){
        composable(MAIN_SCREEN) {
            MainScreen(
                navController = navController,
            )
        }

        composable(SAVE_SCREEN) {
            SaveScreen(
                navController = navController
            )
        }

        composable("$INFORMATION_SAVED_SCREEN/{$id}",) { navBackStack ->

            val counter = navBackStack.arguments?.getString("$id")

            InformationSavedScreen(counter)
        }

    }
}


