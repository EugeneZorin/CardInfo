package com.example.cardinfo.viewmodels.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.cardinfo.room.CardDetailsDatabase
import com.example.cardinfo.room.CardNumberDetails
import kotlinx.coroutines.launch

class CardDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val cardDetailsDao = CardDetailsDatabase.getDatabase(application).cardDetailsDao()

    val allDetails: LiveData<List<CardNumberDetails>> = cardDetailsDao.getAllDetails().asLiveData()

    fun insertDetails(cardNumberDetails: CardNumberDetails) = viewModelScope.launch {
        cardDetailsDao.insertCard(cardNumberDetails)
    }

    fun deleteDetails(cardNumberDetails: CardNumberDetails) = viewModelScope.launch {
        cardDetailsDao.deleteCard(cardNumberDetails)
    }
}