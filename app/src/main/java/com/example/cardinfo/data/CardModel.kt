package com.example.cardinfo.data
data class CardModel (

    val number: Number? = null,
    val country: Country? = null,
    val bank: Bank? = null,

    // All the rest
    val scheme: String? = null,
    var type: String? = null,
    val brand: String? = null,
    val prepaid: String? = null,

    // error handler
    var errorHandler: Boolean? = false
)  {
    data class Number(
        val length: String?,
        val luhn: String?
    )

    data class Country(
        // Country
        val numeric: String?,
        val alpha2: String?,
        val name: String?,
        val emoji: String?,
        val currency: String?,
        val latitude: Int?,
        val longitude: Int?,
    )

    data class Bank(
        //Bank
        val name: String?,
        val url: String?,
        val phone: String?,
        val city: String?,
    )
}