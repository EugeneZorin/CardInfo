package com.example.cardinfo.screencomponents.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardinfo.data.constant.ConstantValue
import com.example.cardinfo.viewmodels.room.CardDetailsViewModel
import com.example.cardinfo.viewmodels.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun InformationSavedScreen(
    counter: String?,
    cardDetailsViewModel: CardDetailsViewModel = viewModel(),
) {

    val id = counter?.toInt()?.minus(1)
    val userDao = cardDetailsViewModel.allDetails.observeAsState(emptyList()).value


    if(userDao.isNotEmpty()){
        if (id != null) {
            Column(Modifier.fillMaxSize()) {
                Text(text = userDao[id].numberCard)
                Text(text = userDao[id].DetailsCard)
            }

        }
    }



    







}