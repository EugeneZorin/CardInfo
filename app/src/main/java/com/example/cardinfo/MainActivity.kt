package com.example.cardinfo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cardinfo.components.CardDataOutput
import com.example.cardinfo.components.CardNumberEntry
import com.example.cardinfo.data.CardModel
import org.json.JSONObject


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val cardInfo = remember {
                mutableStateOf(CardModel())
            }


            getData("45717360", this, cardInfo)


            Column (modifier = Modifier
                .fillMaxSize()
            ) {

                Box (modifier = Modifier
                    .offset(x = 50.dp, y = 20.dp))
                {
                    CardNumberEntry()
                }


                Box (modifier = Modifier
                    .offset(x = 15.dp, y = 50.dp))
                {

                    CardDataOutput(cardInfo)


                }

            }
        }
    }


}


private fun getData(card: String, context: Context, cardInfo: MutableState<CardModel>){
    val url = "https://lookup.binlist.net/$card"

    val queue = Volley.newRequestQueue(context)


    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            val list = getCardData(response)
            cardInfo.value = list[0]

        },
        {
            Log.d("MyLod", "Error: $it")
        }
    )

    queue.add(sRequest)

}

private fun getCardData(response: String): List<CardModel>{

    val list = ArrayList<CardModel>()

    if (response.isEmpty()) return listOf()

    val mainObject = JSONObject(response)

    val number = mainObject.getJSONObject("number")
    val country = mainObject.getJSONObject("country")
    val bank = mainObject.getJSONObject("bank")


    list.add(
       CardModel(
           number.getInt("length"),
           number.getBoolean("luhn"),

           mainObject.getString("scheme"),
           mainObject.getString("type"),
           mainObject.getString("brand"),
           mainObject.getString("prepaid"),

           country.getString("numeric"),
           country.getString("alpha2"),
           country.getString("name"),
           country.getString("emoji"),
           country.getString("currency"),
           country.getInt("latitude"),
           country.getInt("longitude"),

           bank.getString("name"),
           bank.getString("url"),
           bank.getString("phone"),
           bank.getString("city"),

       )
    )

    return list

}