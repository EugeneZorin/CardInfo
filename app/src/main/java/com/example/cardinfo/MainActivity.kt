package com.example.cardinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.requests.checkwriting.RequestWriting
import com.example.cardinfo.screencomponents.MainNavHost
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences

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
