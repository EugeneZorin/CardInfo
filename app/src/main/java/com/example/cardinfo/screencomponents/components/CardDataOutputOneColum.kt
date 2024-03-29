package com.example.cardinfo.screencomponents.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cardinfo.R
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

        if(item.value.isEmpty() || item.value[0].scheme == null)
            QuestionMarks(xParameter = 0, yParameter = 10)


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

        if(item.value.isEmpty() || item.value[0].brand == null)
            QuestionMarks(xParameter = 0, yParameter = 28)


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

        if(item.value.isEmpty() || item.value[0].number?.length == null)
            QuestionMarks(xParameter = 0, yParameter = 50)


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

        if(item.value.isEmpty() || item.value[0].number?.length == null)
            QuestionMarks(xParameter = 0, yParameter = 77)

    }
}
