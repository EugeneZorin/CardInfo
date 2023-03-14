package com.example.cardinfo.components.screens.second

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SavedCard(value: Any?) {

    Card (
        modifier = Modifier
            .offset(x = 20.dp, y = 20.dp)
            .height(45.dp)
            .width(370.dp)
            .padding(top = 3.dp),
        backgroundColor = Color.Blue,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                start = 109.dp,
                top = 5.dp,
                bottom = 5.dp
            )
        ) {
            Text(
                text = value.toString(),
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )
        }
    }
}
