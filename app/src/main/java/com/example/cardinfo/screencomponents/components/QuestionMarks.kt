package com.example.cardinfo.screencomponents.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinfo.ui.theme.Silver

@Composable
fun QuestionMarks( xParameter: Int, yParameter: Int){
    Text(text = "?", color = Silver, modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp))
}

