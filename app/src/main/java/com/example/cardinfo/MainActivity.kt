package com.example.cardinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cardinfo.components.CardNumberEntry
import com.example.cardinfo.components.PricePreview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen(){

    Column (modifier = Modifier
            .fillMaxSize()
    ) {

        Box (modifier = Modifier
            .offset(x = 50.dp, y = 20.dp))
        {
            CardNumberEntry()
        }

        Box (modifier = Modifier
            .offset(x = 15.dp, y = 50.dp))
        {
            PricePreview()
        }

    }

}

