package com.example.cardinfo.components.screens.mainscreen.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.ui.theme.Silver

@Composable
fun QuestionsMarksScheme(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].scheme == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksBrand(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].brand == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksLength(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].number?.length == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksType(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].type == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksPrepaid(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].prepaid == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksEmoji(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].country?.emoji == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksLatitude(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].country?.latitude == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksBankName(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].bank?.name == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksBankUrl(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].bank?.url == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

@Composable
fun QuestionsMarksBankPhone(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int){

    if (item.value.isEmpty() || item.value[0].bank?.phone == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }

}

