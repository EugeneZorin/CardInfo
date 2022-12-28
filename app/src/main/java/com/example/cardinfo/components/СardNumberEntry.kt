package com.example.cardinfo.components
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import com.example.cardinfo.functions.EnteringValue

// Пока в разрабоке
private fun format(value: String): String {
    return value.uppercase()
}


// fields for entering the card number
@Preview(showBackground = true)
@Composable
fun CardNumberEntry() {

    val enteringValue = EnteringValue()
    val pattern = remember { Regex("^\\d+\$") }
    var cardNumber by remember { mutableStateOf("") }

    TextField(
        value = format(cardNumber),

        onValueChange = {
            if (it.isEmpty() || it.matches(pattern)) { cardNumber = it }
        },

        // Filter for entering the card number with a space every 4 digits
        visualTransformation = { enteringValue.creditCardFilter(it) },

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White
        )
    )
}