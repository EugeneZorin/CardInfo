package com.example.cardinfo.screencomponents.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardinfo.R
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.ui.theme.Silver
import java.util.*

@Composable
fun CardDataOutputTwoColum(
    item: MutableState<List<CardModel>>
){

    Column {

        Text(
            text = stringResource(id = R.string.type),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 30.dp, y = 10.dp)
        )

        if (item.value.isNotEmpty()) {
            item.value[0].type?.let {
                Text(
                    text = it.capitalize(Locale.ROOT),
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 10.dp),
                )
            }

        }

        if(item.value.isEmpty() || item.value[0].type == null)
            QuestionMarks(xParameter = 30, yParameter = 10)

        Text(
            text = stringResource(id = R.string.prepaid),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 30.dp, y = 28.dp)
        )

        if (item.value.isNotEmpty()) {
            item.value[0].prepaid?.let {
                Text(
                    text = if (it.toBoolean()) { "Yes" } else { "No"},
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 28.dp)
                )
            }
        }

        if(item.value.isEmpty() || item.value[0].prepaid == null)
            QuestionMarks(xParameter = 30, yParameter = 28)

        Text(
            text = stringResource(id = R.string.country),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 30.dp, y = 50.dp)
        )

        if (item.value.isNotEmpty()) {
            item.value[0].country?.emoji?.let {
                Text(
                    text = "$it ${item.value[0].country?.name}",
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier
                        .offset(x = 30.dp, y = 50.dp)
                )
            }
        }

        if(item.value.isEmpty() || item.value[0].country?.emoji == null)
            QuestionMarks(xParameter = 30, yParameter = 50)

        if (item.value.isNotEmpty()) {
            item.value[0].country?.latitude?.let {
                Text(
                    text = "(latitude: $it}, longitude: ${item.value[0].country?.longitude})",
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    fontSize = 9.sp,
                    modifier = Modifier.offset(x = 30.dp, y = 50.dp)

                )
            }
        }

        if(item.value.isEmpty() || item.value[0].country?.latitude == null)
            QuestionMarks(xParameter = 30, yParameter = 50)

        Text(
            text = stringResource(id = R.string.bank),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 30.dp, y = 75.dp)
        )

        if (item.value.isNotEmpty()) {
            if(item.value[0].bank?.city != null || item.value[0].bank?.name != null) {
                Text(
                    text = if (item.value[0].bank?.city != null) {
                        "${item.value[0].bank?.name}, ${item.value[0].bank?.city}"
                    } else {
                        "${item.value[0].bank?.name}"
                    },
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 75.dp)
                )
            }
        }

        if(item.value.isEmpty() || item.value[0].bank?.name == null)
            QuestionMarks(xParameter = 30, yParameter = 75)

        if(item.value.isNotEmpty()){
            if (item.value[0].bank?.url != null) {
                Text(
                    text = "${item.value[0].bank?.url}",
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 75.dp)
                )
            }
        }

        if(item.value.isEmpty() || item.value[0].bank?.url == null)
            QuestionMarks(xParameter = 30, yParameter = 75)

        if(item.value.isNotEmpty()){
            if (item.value[0].bank?.phone != null) {
                Text(
                    text = "+${item.value[0].bank?.phone}",
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 75.dp)
                )
            }
        }

        if(item.value.isEmpty() || item.value[0].bank?.phone == null)
            QuestionMarks(xParameter = 30, yParameter = 75)
    }
}