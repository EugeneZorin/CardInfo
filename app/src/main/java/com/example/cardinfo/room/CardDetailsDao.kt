package com.example.cardinfo.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDetailsDao {

    @Query("SELECT * FROM card_number_details")
    fun getAllDetails(): Flow<List<CardDetails>>

    @Query("SELECT * FROM card_number_details WHERE id = :id")
    fun getValueById(id: Int): Flow<List<CardDetails>>

    @Query("SELECT numberCard FROM card_number_details WHERE numberCard = :cardNumber")
    fun getCardNumber(cardNumber: String): Flow<String>

    @Insert
    suspend fun insertCard(cardNumberDetails: CardDetails)

    @Delete
    suspend fun deleteCard(cardNumberDetails: CardDetails)

}