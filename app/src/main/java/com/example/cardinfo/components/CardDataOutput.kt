package com.example.cardinfo.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cardinfo.R
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.ui.theme.Silver


// General information about the card for the user

@Composable
fun CardDataOutput(
    cardAllData: MutableState<CardModel>

){

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
        
        Text(
            text = cardAllData.value.scheme,
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(dataSchemeNetwork){
                top.linkTo(textSchemaNetwork.bottom)
            }
        )

        Text(
            text = stringResource(id = R.string.brand),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(textBrand){
                top.linkTo(dataSchemeNetwork.bottom, margin = 20.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = cardAllData.value.brand,
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(dataBrand){
                top.linkTo(textBrand.bottom)
            }
        )

        Text(
            text = stringResource(id = R.string.card_number),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(textCardNumber){
                top.linkTo(dataBrand.bottom, margin = 20.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(id = R.string.length),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(textLength){
                top.linkTo(textCardNumber.bottom)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = cardAllData.value.length.toString(),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(dataCardNumber){
                top.linkTo(textLength.bottom)
            }
        )



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



        Text(
            text = cardAllData.value.type,
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(dataType){
                start.linkTo(textType.start)
                top.linkTo(textType.bottom)
            }
        )

        Text(
            text = stringResource(id = R.string.prepaid),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .constrainAs(textPrepaid) {

                    top.linkTo(dataType.bottom, margin = 20.dp)
                    start.linkTo(dataType.start)

                }
        )

        Text(
            text = cardAllData.value.prepaid,
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(dataPrepaid){
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

                    top.linkTo(dataPrepaid.bottom, margin = 20.dp)
                    start.linkTo(dataPrepaid.start)

                }
        )

        Text(
            text = cardAllData.value.countyName,
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(dataCountry){
                start.linkTo(textCountry.start)
                top.linkTo(textCountry.bottom)
            }
        )

        Text(
            text = "(latitude: ${cardAllData.value.latitude}, longitude: ${cardAllData.value.longitude})",
            style = typography.subtitle2,
            color = Silver,
            fontSize = 9.sp,

            modifier = Modifier.constrainAs(textCoordinates){
                start.linkTo(dataCountry.start)
                top.linkTo(dataCountry.bottom)
            }
        )

        Text(
            text = stringResource(id = R.string.bank),
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier
                .constrainAs(textBank) {
                    top.linkTo(textCoordinates.bottom, margin = 20.dp)
                    start.linkTo(textCoordinates.start)

                }
        )

        Text(
            text = cardAllData.value.name,
            style = typography.subtitle2,
            color = Silver,
            modifier = Modifier.constrainAs(dataBank){
                start.linkTo(textBank.start)
                top.linkTo(textBank.bottom)
            }
        )
    }
}


