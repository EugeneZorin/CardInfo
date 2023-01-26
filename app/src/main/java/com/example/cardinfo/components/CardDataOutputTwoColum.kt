package com.example.cardinfo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
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

@Composable
fun CardDataOutputTwoColum(item: MutableState<List<CardModel>>){


    Column{

        Text(
            text = stringResource(id = R.string.type),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 30.dp, y = 10.dp)
        )

        if (item.value.isNotEmpty()) {
            item.value[0].type?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 10.dp)
                )
            }
        }
        QuestionInsteadMeaning(item, 30, 10)


        Text(
            text = stringResource(id = R.string.prepaid),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 30.dp, y = 28.dp)
        )

        if (item.value.isNotEmpty()) {
            item.value[0].prepaid?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 28.dp)
                )
            }
        }
        QuestionInsteadMeaning(item, 30, 28)

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
                    modifier = Modifier.offset(x = 30.dp, y = 50.dp)
                )
            }
        }
        QuestionInsteadMeaning(item, 30, 50)


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
        QuestionInsteadMeaning(item, 30, 50)

        Text(
            text = stringResource(id = R.string.bank),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier.offset(x = 30.dp, y = 75.dp)
        )


        if (item.value.isNotEmpty()) {
            if(item.value[0].bank?.city != null) {
                Text(
                    text = "${item.value[0].bank?.name}, ${item.value[0].bank?.city}" +
                            "\n${item.value[0].bank?.url}" +
                            "\n${item.value[0].bank?.phone}",

                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 30.dp, y = 75.dp)
                )
            }
        }
        QuestionInsteadMeaning(item, 30, 75)
        QuestionInsteadMeaning(item, 30, 75)
        QuestionInsteadMeaning(item, 30, 75)
    }


    //old code
    /*ConstraintLayout(modifier = Modifier) {
        val (
            textType, dataType,
            textPrepaid, dataPrepaid,
            textCountry, dataCountry,
            textBank, dataBank,
            textCoordinates

        ) = createRefs()

        Text(
            text = stringResource(id = R.string.type),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(textType) {

                    end.linkTo(parent.end)
                    start.linkTo(parent.start)

                }
        )

        if (item.value.isNotEmpty()) {
            item.value[0].type?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataType) {
                        start.linkTo(textType.start)
                        top.linkTo(textType.bottom)
                    }
                )
            }
        }

        Text(
            text = stringResource(id = R.string.prepaid),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .constrainAs(textPrepaid) {
                    top.linkTo(textType.bottom, margin = 40.dp)
                    start.linkTo(textType.start)
                }
        )

        if (item.value.isNotEmpty()) {
            item.value[0].prepaid?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataPrepaid) {
                        start.linkTo(textPrepaid.start)
                        top.linkTo(textPrepaid.bottom)
                    }
                )
            }
        }

        Text(
            text = stringResource(id = R.string.country),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .constrainAs(textCountry) {
                    top.linkTo(textPrepaid.bottom, margin = 40.dp)
                    start.linkTo(textPrepaid.start)
                }
        )

        if (item.value.isNotEmpty()) {
            item.value[0].country?.emoji?.let {
                Text(
                    text = "$it ${item.value[0].country?.name}",
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataCountry) {
                        start.linkTo(textCountry.start)
                        top.linkTo(textCountry.bottom)
                    }
                )
            }
        }

        if (item.value.isNotEmpty()) {
            item.value[0].country?.latitude?.let {
                Text(
                    text = "(latitude: $it}, longitude: ${item.value[0].country?.longitude})",
                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    fontSize = 9.sp,

                    modifier = Modifier.constrainAs(textCoordinates) {
                        start.linkTo(dataCountry.start)
                        top.linkTo(dataCountry.bottom)
                    }
                )
            }
        }

        Text(
            text = stringResource(id = R.string.bank),
            style = MaterialTheme.typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .constrainAs(textBank) {
                    top.linkTo(textCountry.bottom, margin = 50.dp)
                    start.linkTo(textCountry.start)

                }
        )

        if (item.value.isNotEmpty()) {
            if ( item.value[0].bank != null){
                Text(
                    text = "${item.value[0].bank?.name}, ${item.value[0].bank?.city}" +
                            "\n${item.value[0].bank?.url}" +
                            "\n${item.value[0].bank?.phone}",


                    style = MaterialTheme.typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataBank) {
                        start.linkTo(textBank.start)
                        top.linkTo(textBank.bottom)
                    }
                )
            }
        }

    }*/

}