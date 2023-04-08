package com.example.cardinfo.functions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import com.example.cardinfo.data.constant.ConstantValue.BRACKETS_WITHOUT_SPACES


class EnteringValue {

    // Default card number
    private val defaultCardNumber = "0000 0000 0000 0000"

    // Filter for entering the card number with a space every 4 digits
    fun filter(cardNumber: AnnotatedString): TransformedText {

        val trimmed = if (cardNumber.text.length >= 16) {
            cardNumber.text.substring(0..15)
        } else { cardNumber.text }

        val annotatedString = AnnotatedString.Builder().run {
            for (i in trimmed.indices) {
                append(trimmed[i])
                if (i % 4 == 3 && i != 15) {
                    append(" ")
                }
            }
            pushStyle(SpanStyle(color = Color.LightGray))
            append(defaultCardNumber.takeLast(defaultCardNumber.length - length))
            toAnnotatedString()
        }

        val creditCardOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 3) return offset
                if (offset <= 7) return offset + 1
                if (offset <= 11) return offset + 2
                if (offset <= 16) return offset + 3
                return 19
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 4) return offset
                if (offset <= 9) return offset - 1
                if (offset <= 14) return offset - 2
                if (offset <= 19) return offset - 3
                return 16
            }
        }

        return TransformedText(annotatedString, creditCardOffsetTranslator)
    }
}