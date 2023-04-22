package com.example.cardinfo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_number_details")
data class CardDetails(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    // detailed information about the card
    val allCardDetails: String,

    val numberCard: String,
)
