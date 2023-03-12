package com.example.cardinfo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinfo.components.screens.second.ButtonBack
import com.example.cardinfo.components.screens.second.SavedCard

class SecondActivity: ComponentActivity() {
    private lateinit var preferencesAllSaveData: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Temporary solution (not a solution at all)
        preferencesAllSaveData = getSharedPreferences("TEST", Context.MODE_PRIVATE)
        val value = intent.getStringExtra("key1")
        preferencesAllSaveData.edit().putString(value, null).apply()



        setContent{

            SecondScreen(preferencesAllSaveData)

        }
    }

    fun openMainActivity(context: Context){
        intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}

@Composable
fun SecondScreen(preferencesAllSaveData: SharedPreferences) {



    Box(modifier = Modifier
        .height(520.dp)
        .offset(x = 0.dp, y = 15.dp)

    ) {
        LazyColumn(
           modifier = Modifier.fillMaxSize()
        ) {
            items(preferencesAllSaveData.all.size) {
                SavedCard()
            }
        }
    }


    Box(modifier = Modifier
        .offset(x = 145.dp, y = 570.dp)
        .fillMaxSize())
    {
        ButtonBack()
    }
}

