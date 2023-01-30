package com.example.cardinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinfo.components.screens.basic.ButtonOpenSecondScreen
import com.example.cardinfo.components.screens.basic.ButtonSave
import com.example.cardinfo.components.screens.second.ButtonBack

class SecondActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SecondScreen()
        }
    }

    fun openMainActivity(context: Context){
        intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}

@Composable
fun SecondScreen(){

    Box(modifier = Modifier
        .offset(x = 145.dp, y = 570.dp)
        .fillMaxSize())
    {
        ButtonBack()
    }
}