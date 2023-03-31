package com.example.cardinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cardinfo.components.screens.savescreen.SaveScreen
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel

class SaveActivity: ComponentActivity() {

    private val cardDetailsViewModel: CardDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            SaveScreen(cardDetailsViewModel)
        }
    }

    fun openMainActivity(context: Context){
        intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}


