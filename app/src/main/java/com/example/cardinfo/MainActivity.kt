package com.example.cardinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cardinfo.requests.checkwriting.RequestWriting
import com.example.cardinfo.screencomponents.MainNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainNavHost() }
    }

    override fun onDestroy() {
        super.onDestroy()
        val requestWriting = RequestWriting()
        requestWriting.canselRequest()
    }
}
