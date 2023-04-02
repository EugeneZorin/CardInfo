package com.example.cardinfo.components.screens.mainscreen.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.cardinfo.data.CardModel
import com.example.cardinfo.data.constant.ConstantValue.FOUR
import com.example.cardinfo.data.constant.ConstantValue.HOME_SCREEN_VALUES
import com.example.cardinfo.data.constant.ConstantValue.INPUT_VALUE
import com.example.cardinfo.data.constant.ConstantValue.REGEX
import com.example.cardinfo.data.constant.ConstantValue.SEVEN
import com.example.cardinfo.data.constant.ConstantValue.TREE
import com.example.cardinfo.functions.EnteringValue
import com.example.cardinfo.functions.SavingStateMainScreen
import com.example.cardinfo.requests.RequestAdapter
import com.example.cardinfo.requests.RequestProcessing
import com.example.cardinfo.viewmodelshared.ViewModelSharedPreferences
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Response

// fields for entering the card number
@OptIn(DelicateCoroutinesApi::class)
@Composable
fun CardNumberEntry(
    cardInfoCardModel: MutableState<List<CardModel>>,
    characterLimitSubmittingRequest: MutableState<Int>,
    cardNumber: String,
    checkingFirstRequest: MutableState<Boolean>,
    responseSaveData: MutableState<List<Response>>,
    preferencesHomeScreenValue: ViewModelSharedPreferences,
) {

    val requestProcessing = RequestProcessing()
    val requestAdapter = RequestAdapter()
    val savingStateMainScreen = SavingStateMainScreen()

    /*val enteringValue = EnteringValue()*/

    val pattern = Regex(REGEX)

    var cardNumberRemember by rememberSaveable() { mutableStateOf(cardNumber) }

    val key = preferencesHomeScreenValue.getData(INPUT_VALUE)

    if (key != null){
        cardNumberRemember = key.toString()
    }



    OutlinedTextField(
        value = cardNumberRemember ,
        onValueChange = {

            if (key != null) { savingStateMainScreen.checkingKey(key, checkingFirstRequest) }

            /*
            * Check to send a new request for another card
            * If the request has already been sent, then the value of checkingFirstRequest becomes true.
            * If the value 3 and 7 becomes greater than or equal to the length of the card, then the input of a new card number is fixed
            * The default value is set to the number of characters of the entered value to send the request
            * as is required for API 27 and lower or when using the default
            * Delete old values from CardModel
            * */

            if (cardNumberRemember.length <= TREE || cardNumberRemember.length <= SEVEN) {
                if(checkingFirstRequest.value){
                    characterLimitSubmittingRequest.value = FOUR
                    cardInfoCardModel.value = listOf(CardModel())
                    checkingFirstRequest.value = false
                    preferencesHomeScreenValue.deleteData(INPUT_VALUE)
                    preferencesHomeScreenValue.deleteData(HOME_SCREEN_VALUES)
                }
            }

            GlobalScope.launch {
                if (it.isEmpty() || it.matches(pattern)) {

                    cardNumberRemember = it
                    preferencesHomeScreenValue.saveData(INPUT_VALUE, it)

                    // Sends the url to RequestProcessing if the entered characters are greater than or equal to 4
                    // 4 is added to the number of characters for the next sending

                    if (cardNumberRemember.length >= characterLimitSubmittingRequest.value) {

                        characterLimitSubmittingRequest.value += FOUR
                        checkingFirstRequest.value = true

                        responseSaveData.value = listOf(requestProcessing.getData(cardNumberRemember))

                        cardInfoCardModel.value = requestAdapter.requestAdapter(
                            responseSaveData.value,
                            preferencesHomeScreenValue,
                            cardNumberRemember
                        )
                    }
                }
            }
        },

      /*  // Filter for entering the card number with a space every 4 digits
        visualTransformation = { enteringValue.creditCardFilter(it) },*/

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White
        )
    )
}


