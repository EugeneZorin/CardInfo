package com.example.cardinfo.components.screens.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cardinfo.R
import com.example.cardinfo.components.QuestionsMarksBrand
import com.example.cardinfo.components.QuestionsMarksLength
import com.example.cardinfo.components.QuestionsMarksScheme
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.ui.theme.Silver
import java.util.*


// General information about the card for the user
@Composable
fun CardDataOutputOneColum(item: MutableState<List<CardModel>>) {



    Column {
        Text(
            text = stringResource(id = R.string.scheme_network),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 0.dp, y = 10.dp)
        )

        if (item.value.isNotEmpty()) {
            item.value[0].scheme?.let {
                Text(
                    text = it.capitalize(Locale.ROOT),
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 0.dp, y = 10.dp)
                )
            }
        }
        QuestionsMarksScheme(item, 0, 10)

        Text(
            text = stringResource(id = R.string.brand),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 0.dp, y = 28.dp)

        )

        if (item.value.isNotEmpty()) {
            item.value[0].brand?.let {
                Text(
                    text = it,
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 0.dp, y = 28.dp)
                )
            }
        }
        QuestionsMarksBrand(item, 0, 28)


        Text(
            text = stringResource(id = R.string.card_number),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 0.dp, y = 50.dp)

        )

        Text(
            text = stringResource(id = R.string.length),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 0.dp, y = 50.dp)

        )

        if (item.value.isNotEmpty()) {
            item.value[0].number?.length?.let{
                Text(
                    text = it,
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 0.dp, y = 50.dp)

                )
            }
        }
        QuestionsMarksLength(item, 0, 50)

        Text(
            text = stringResource(id = R.string.luhn),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 0.dp, y = 77.dp)

        )

        if (item.value.isNotEmpty()) {
            item.value[0].number?.luhn?.let{
                Text(
                    text = if (it.toBoolean()) { "Yes" } else { "No"},
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 0.dp, y = 77.dp)

                )
            }
        }
        QuestionsMarksLength(item, 0, 77)
    }
}
