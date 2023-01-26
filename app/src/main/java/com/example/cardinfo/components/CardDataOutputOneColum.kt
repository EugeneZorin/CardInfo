package com.example.cardinfo.components

import androidx.compose.foundation.layout.Column
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


@Composable
fun QuestionInsteadMeaning(item: MutableState<List<CardModel>>, xParameter: Int, yParameter: Int) {

    if (item.value.isEmpty() || item.value[0].scheme == null) {
        Text(text = "?",
            color = Silver,
            modifier = Modifier.offset(x = xParameter.dp, y = yParameter.dp)
        )
    }
}

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
                    text = it,
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.offset(x = 0.dp, y = 10.dp)
                )
            }
        }
        QuestionInsteadMeaning(item, 0, 10)

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
        QuestionInsteadMeaning(item, 0, 28)


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
        QuestionInsteadMeaning(item, 0, 50)
    }
}


    //old code
    /*ConstraintLayout(modifier = Modifier) {
        val (
            textSchemaNetwork, dataSchemeNetwork,
            textBrand, dataBrand,
            textCardNumber, dataCardNumber, textLength,

        ) = createRefs()

        Text(
            text = stringResource(id = R.string.scheme_network),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(textSchemaNetwork) {
                    start.linkTo(parent.start)
                }
        )

        if (item.value.isNotEmpty()) {
            item.value[0].scheme?.let {
                Text(
                    text = it,
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataSchemeNetwork) {
                        top.linkTo(textSchemaNetwork.bottom)
                    }
                )
            }

        }

        Text(
            text = stringResource(id = R.string.brand),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(textBrand) {
                top.linkTo(textSchemaNetwork.bottom, margin = 40.dp)
                start.linkTo(parent.start)
            }
        )

        if (item.value.isNotEmpty()) {
            item.value[0].brand?.let {
                Text(
                    text = it,
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataBrand) {
                        top.linkTo(textBrand.bottom)
                    }
                )
            }
        }

        Text(
            text = stringResource(id = R.string.card_number),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(textCardNumber) {
                top.linkTo(textBrand.bottom, margin = 40.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(id = R.string.length),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(textLength) {
                top.linkTo(textCardNumber.bottom)
                start.linkTo(parent.start)
            }
        )

        if (item.value.isNotEmpty()) {
            item.value[0].number?.length?.let{
                Text(
                    text = it,
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataCardNumber) {
                        top.linkTo(textLength.bottom)
                    }
                )
            }
        }
    }*/





