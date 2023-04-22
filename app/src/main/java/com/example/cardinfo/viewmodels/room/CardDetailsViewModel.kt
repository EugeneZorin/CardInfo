package com.example.cardinfo.viewmodels.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.cardinfo.room.CardDetailsDatabase
import com.example.cardinfo.room.CardDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CardDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val cardDetailsDao = CardDetailsDatabase.getDatabase(application).cardDetailsDao()

    val allDetails: LiveData<List<CardDetails>> = cardDetailsDao.getAllDetails().asLiveData()

    // Search for card data by saved id
    fun gettingInformationCardById(id: Int): Flow<List<CardDetails>> {
        return cardDetailsDao.getValueById(id)
    }

    fun insertDetails(cardNumberDetails: CardDetails) = viewModelScope.launch {
        cardDetailsDao.insertCard(cardNumberDetails)
    }

    fun deleteDetails(cardNumberDetails: CardDetails) = viewModelScope.launch {
        cardDetailsDao.deleteCard(cardNumberDetails)
    }

}