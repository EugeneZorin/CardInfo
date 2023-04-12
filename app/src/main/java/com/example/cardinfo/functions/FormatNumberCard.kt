package com.example.cardinfo.functions

import com.example.cardinfo.data.constant.ConstantValue.FOUR
import com.example.cardinfo.data.constant.ConstantValue.FOURTEEN
import com.example.cardinfo.data.constant.ConstantValue.NINE
import com.example.cardinfo.data.constant.ConstantValue.WHITESPACE

class FormatNumberCard {

    // Turns recorded card number from 0000000000000000 to 0000 0000 0000 0000
    fun formatNumberCard(number: String): String {
        val sb = StringBuilder(number)
        if (sb.length >= FOUR) sb.insert(FOUR, WHITESPACE)
        if (sb.length >= NINE) sb.insert(NINE, WHITESPACE)
        if (sb.length >= FOURTEEN) sb.insert(FOURTEEN, WHITESPACE)
        return sb.toString()
    }
}