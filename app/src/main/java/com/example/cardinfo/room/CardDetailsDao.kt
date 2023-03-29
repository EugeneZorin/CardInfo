package com.example.cardinfo.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDetailsDao {

    @Query("SELECT * FROM card_number_details")
    fun getAllDetails(): Flow<List<CardNumberDetails>>

    @Insert
    suspend fun insertCard(cardNumberDetails: CardNumberDetails)

    @Delete
    suspend fun deleteCard(cardNumberDetails: CardNumberDetails)

}