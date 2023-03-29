package com.example.cardinfo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_number_details")
data class CardNumberDetails(

    @PrimaryKey(autoGenerate = true) val id: Long?,

    val numberCard: String,

    // detailed information about the map
    val DetailsCard: String
)
