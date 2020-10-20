package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(val reason: String, val result: Result, @SerializedName("error_code") val status: Int)

data class Result(val city: String, val realtime: Realtime, val future: List<Future>)

data class Realtime(val temperature: String, val humidity: String, val info: String, val wid: String, val direct: String, val power: String, val aqi: String)

data class Future(val date: String, val temperature: String, val weather: String, val wid: Wid, val direct: String)

data class Wid(val day: String, val night: String)
