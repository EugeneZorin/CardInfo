package com.example.cardinfo.data

data class CardModel(

    val number: Number? = null,
    val country: Bank? = null,
    val bank: Country? = null,

    // All the rest
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: String? = null,
) {
    data class Number(
        val length: String?,
        val luhn: Boolean
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