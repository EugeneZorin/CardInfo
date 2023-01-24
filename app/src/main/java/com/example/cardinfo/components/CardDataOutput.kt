package com.example.cardinfo.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cardinfo.R
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.ui.theme.Silver


// General information about the card for the user
@Composable
fun CardDataOutput(item: MutableState<List<CardModel>>) {


    ConstraintLayout(modifier = Modifier) {
        val (
            textSchemaNetwork, dataSchemeNetwork,
            textBrand, dataBrand,
            textCardNumber, dataCardNumber, textLength,
            textType, dataType,
            textPrepaid, dataPrepaid,
            textCountry, dataCountry,
            textBank, dataBank,
        ) = createRefs()

        val (
            textCoordinates,
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


        /*Text(
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
            Text(
                text = item.value[0].number.length,
                style = typography.subtitle2,
                color = Silver,
                modifier = Modifier.constrainAs(dataCardNumber) {
                    top.linkTo(textLength.bottom)
                }
            )
        }

        Text(
            text = stringResource(id = R.string.type),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(textType) {

                    end.linkTo(parent.end)
                    start.linkTo(parent.start, margin = 200.dp)

                }
        )

        if (item.value.isNotEmpty()) {
            Text(
                text = item.value[0].type,
                style = typography.subtitle2,
                color = Silver,
                modifier = Modifier.constrainAs(dataType) {
                    start.linkTo(textType.start)
                    top.linkTo(textType.bottom)
                }
            )
        }

        Text(
            text = stringResource(id = R.string.prepaid),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .constrainAs(textPrepaid) {
                    top.linkTo(textType.bottom, margin = 40.dp)
                    start.linkTo(textType.start)
                }
        )

        if (item.value.isNotEmpty())
            Text(
                text = item.value[0].prepaid,
                style = typography.subtitle2,
                color = Silver,
                modifier = Modifier.constrainAs(dataPrepaid) {
                    start.linkTo(textPrepaid.start)
                    top.linkTo(textPrepaid.bottom)
                }
            )

        Text(
            text = stringResource(id = R.string.country),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .constrainAs(textCountry) {
                    top.linkTo(textPrepaid.bottom, margin = 40.dp)
                    start.linkTo(textPrepaid.start)
                }
        )

        if (item.value.isNotEmpty()) {

            Text(
                text = "${item.value[0].country.emoji} ${item.value[0].country.name}",
                style = typography.subtitle2,
                color = Silver,
                modifier = Modifier.constrainAs(dataCountry) {
                    start.linkTo(textCountry.start)
                    top.linkTo(textCountry.bottom)
                }
            )
        }

        if (item.value.isNotEmpty()) {
            Text(
                text = "(latitude: ${item.value[0].country.latitude}, longitude: ${item.value[0].country.longitude})",
                style = typography.subtitle2,
                color = Silver,
                fontSize = 9.sp,

                modifier = Modifier.constrainAs(textCoordinates) {
                    start.linkTo(dataCountry.start)
                    top.linkTo(dataCountry.bottom)
                }
            )
        }

        Text(
            text = stringResource(id = R.string.bank),
            style = typography.subtitle2,
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
                    text = "${item.value[0].bank.name}, ${item.value[0].bank.city}" +
                            "\n${item.value[0].bank.url}" +
                            "\n${item.value[0].bank.phone}",
                    style = typography.subtitle2,
                    color = Silver,
                    modifier = Modifier.constrainAs(dataBank) {
                        start.linkTo(textBank.start)
                        top.linkTo(textBank.bottom)
                    }
                )
            }
        }*/
    }
}




