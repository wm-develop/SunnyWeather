package com.sunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.Result

object PlaceDao {

    fun savePlace(city: String) {
        sharedPreferences().edit {
            putString("city", Gson().toJson(city))
        }
    }

    fun getSavedPlace(): String {
        val resultJson = sharedPreferences().getString("city", "")
        return Gson().fromJson(resultJson, String::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("city")

    private fun sharedPreferences() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}