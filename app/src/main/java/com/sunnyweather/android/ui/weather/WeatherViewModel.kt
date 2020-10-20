package com.sunnyweather.android.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.WeatherResponse

class WeatherViewModel : ViewModel() {

    private val cityLiveData = MutableLiveData<String>()

    lateinit var weatherList: WeatherResponse

    var city = ""

    val weatherLiveData = Transformations.switchMap(cityLiveData) { city ->
        Repository.searchWeather(city)
    }

    fun refreshWeather(city: String) {
        cityLiveData.value = city
    }

}