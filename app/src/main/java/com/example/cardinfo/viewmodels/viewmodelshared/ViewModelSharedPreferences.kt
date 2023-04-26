package com.example.cardinfo.viewmodels.viewmodelshared

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.cardinfo.data.constant.ConstantValue.MAIN_DATA

class ViewModelSharedPreferences(application: Application): AndroidViewModel(application) {

    private var preferencesHomeScreenData = application.getSharedPreferences(
        MAIN_DATA,
        Context.MODE_PRIVATE
    )

    fun saveData(key: String, value: String){
        preferencesHomeScreenData.edit().putString(key, value).apply()
    }

    fun deleteData(value: String){
        preferencesHomeScreenData.edit().remove(value).apply()
    }

    fun getData(key: String): String?{
        return preferencesHomeScreenData.getString(key, null)
    }

}