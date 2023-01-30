package com.example.cardinfo.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.functions.EnteringValue
import com.example.cardinfo.requests.RequestProcessing
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// fields for entering the card number
@OptIn(DelicateCoroutinesApi::class)
@Composable
fun CardNumberEntry(
    cardInfoCardModel: MutableState<List<CardModel>>,
    characterLimitSubmittingRequest: MutableState<Int>
) {

    val enteringValue = EnteringValue()
    val requestProcessing = RequestProcessing()

    val checkingFirstRequest = remember { mutableStateOf(false) }
    val pattern = remember { Regex("^\\d+\$") }
    var cardNumber by remember { mutableStateOf("") }
    val cardModel = CardModel()

    OutlinedTextField(
        value = cardNumber,
        onValueChange = {

            /*
            * Check to send a new request for another card
            * If the request has already been sent, then the value of checkingFirstRequest becomes true.
            * If the value 3 and 7 becomes greater than or equal to the length of the card, then the input of a new card number is fixed
            * The default value is set to the number of characters of the entered value to send the request
            * as is required for API 27 and lower or when using the default
            * Delete old values from CardModel
            * */

            if (cardNumber.length <= 3 || cardNumber.length <= 7) { if(checkingFirstRequest.value){
                    characterLimitSubmittingRequest.value = 4
                    cardInfoCardModel.value = listOf(cardModel)
                    checkingFirstRequest.value = false
                }
            }


            GlobalScope.launch {
                if (it.isEmpty() || it.matches(pattern)) {
                    cardNumber = it

                    // Sends the url to RequestProcessing if the entered characters are greater than or equal to 4
                    // 4 is added to the number of characters for the next sending

                    if (cardNumber.length >= characterLimitSubmittingRequest.value) {
                        characterLimitSubmittingRequest.value += 4
                        checkingFirstRequest.value = true
                        cardInfoCardModel.value = requestProcessing.getData(cardNumber)
                    }
                }
            }
        },

        // Filter for entering the card number with a space every 4 digits
        visualTransformation = { enteringValue.creditCardFilter(it) },

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White
        )
    )
}


