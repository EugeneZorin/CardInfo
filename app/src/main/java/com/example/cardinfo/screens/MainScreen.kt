package com.example.cardinfo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardinfo.ui.theme.DarkGray


private fun format(value: String): String {
    return value.uppercase()
}

@Preview (showBackground = true)
@Composable
fun MainScreen(){

    var cardData by rememberSaveable { mutableStateOf("") }

    // Entering the value of the card number
    Box(
        modifier = Modifier
            .width(275.dp)
            .height(70.dp)
            .offset(x = 55.dp, y = 100.dp)
    ) {
        OutlinedTextField(
            value = format(cardData),
            onValueChange = { cardData = it },
            label = {
                Text(
                    text = "Enter the first digits of a card number",
                    fontSize = 14.sp)},

            placeholder = { Text(text = "Card number",)},
            maxLines = 1,
        )
    }

    ColumnOne()
    ColumnTwo()

}

@Composable
fun ColumnOne(){
    // Colum one
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .offset(x = 15.dp, y = 60.dp)
    ) {

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(60.dp)
                .offset(x = 25.dp, y = 150.dp)
        ) { SchemaNetwork() }

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(60.dp)
                .offset(x = 25.dp, y = 160.dp)
        ) { Brand() }

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(60.dp)
                .offset(x = 25.dp, y = 170.dp)
        ) { CardNumber() }

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(60.dp)
                .offset(x = 25.dp, y = 180.dp)
        ) { Bank() }
    }

}

@Composable
fun ColumnTwo(){
    // Colum two
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .offset(x = 230.dp, y = 60.dp)
    ) {

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(60.dp)
                .offset(x = 25.dp, y = 150.dp)
        ) { Type() }

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(60.dp)
                .offset(x = 25.dp, y = 160.dp)
        ) { Prepaid() }

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(60.dp)
                .offset(x = 25.dp, y = 170.dp)
        ) { Country() }

    }

}

@Composable
fun SchemaNetwork(){

    val infoSchemeNetwork by rememberSaveable {
        mutableStateOf("?")
    }

    Column {
        Text(
            color = DarkGray,
            text = "SCHEME / NETWORK",
            fontSize = 9.sp,
        )
        if (infoSchemeNetwork == "?") {
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        } else {
            Text(
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        }
    }
}

@Composable
fun Brand(){

    val infoSchemeNetwork by rememberSaveable {
        mutableStateOf("?")
    }

    Column {
        Text(
            color = DarkGray,
            text = "BRAND",
            fontSize = 9.sp,
        )
        if (infoSchemeNetwork == "?") {
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        } else {
            Text(
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        }
    }
}

@Composable
fun CardNumber(){

    val infoSchemeNetwork by rememberSaveable {
        mutableStateOf("?")
    }

    Column {
        Text(
            color = DarkGray,
            text = "CARD NUMBER",
            fontSize = 9.sp,
        )
        Text(
            color = DarkGray,
            text = "LENGTH",
            fontSize = 8.sp,
        )
        if (infoSchemeNetwork == "?") {
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        } else {
            Text(
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        }
    }
}

@Composable
fun Type(){
    val infoSchemeNetwork by rememberSaveable {
        mutableStateOf("Debit / Credit")
    }

    Column {
        Text(
            color = DarkGray,
            text = "TYPE",
            fontSize = 9.sp,
        )
        if (infoSchemeNetwork == "Debit / Credit") {
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        } else {
            Text(
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        }
    }

}

@Composable
fun Prepaid(){
    val infoSchemeNetwork by rememberSaveable {
        mutableStateOf("YES / NO")
    }

    Column {
        Text(
            color = DarkGray,
            text = "PREPAID",
            fontSize = 9.sp,
        )
        if (infoSchemeNetwork == "YES / NO") {
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        } else {
            Text(
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        }
    }
}

@Composable
fun Country(){
    val infoSchemeNetwork by rememberSaveable {
        mutableStateOf("?")
    }

    Column {
        Text(
            color = DarkGray,
            text = "COUNTRY",
            fontSize = 9.sp,
        )
        if (infoSchemeNetwork == "?") {
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        } else {
            Text(
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        }
        Text(
            color = DarkGray,
            text = "(latitude: $infoSchemeNetwork, " +
                    "longitude: $infoSchemeNetwork)",
            fontSize = 11.sp,
        )
    }
}

@Composable
fun Bank(){
    val infoSchemeNetwork by rememberSaveable {
        mutableStateOf("?")
    }

    Column {
        Text(
            color = DarkGray,
            text = "COUNTRY",
            fontSize = 9.sp,
        )
        if (infoSchemeNetwork == "?") {
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
            Text(
                color = DarkGray,
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        } else {
            Text(
                text = infoSchemeNetwork,
                fontSize = 9.sp
            )
        }

    }
}


