package com.example.cardinfo.data

import org.json.JSONObject

data class CardModel(

    // Number
    val length: Int = 1000,
    val luhn: Boolean = false,

    // All the rest
    val scheme: String = "No Data",
    val type: String = "No Data",
    val brand: String = "No Data",
    val prepaid: String = "No Data",

    // Country
    val numeric: String = "No Data",
    val alpha2: String = "No Data",
    val countyName: String = "No Data",
    val emoji: String = "No Data",
    val currency: String = "No Data",
    val latitude: Int = 1000,
    val longitude: Int = 1000,

    //Bank
    val name: String = "No Data",
    val url: String = "No Data",
    val phone: String = "No Data",
    val city: String = "No Data",

)
