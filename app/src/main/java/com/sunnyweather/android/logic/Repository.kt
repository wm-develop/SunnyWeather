package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.LogUtil
import com.sunnyweather.android.logic.dao.PlaceDao
import com.sunnyweather.android.logic.model.WeatherResponse
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object Repository {

    fun searchPlaces(city: String) = fire(Dispatchers.IO) {
        LogUtil.d("Repository", "Repository.searchPlaces方法已被调用")
        LogUtil.d("Repository", "try代码块已开始执行")
        val placeResponse = SunnyWeatherNetwork.searchWeather(city)
        LogUtil.d("Repository", "已获取到placeResponse.status:${placeResponse.status}")
        if (placeResponse.status == 0) {
            val city = placeResponse.result.city
            LogUtil.d("Repository", city)
            Result.success(city)
        } else {
            LogUtil.d("Repository", "请求失败")
            Result.failure(RuntimeException("response status is failure"))
        }
    }

    fun searchWeather(city: String) = fire(Dispatchers.IO) {
        val weatherResponse = SunnyWeatherNetwork.searchWeather(city)
        if (weatherResponse.status == 0) Result.success(weatherResponse)
        else Result.failure(RuntimeException("response status is failure"))
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) = liveData<Result<T>>(context) {
        val result = try {
            block()
        } catch (e: Exception) {
            Result.failure<T>(e)
        }
        emit(result)
    }

    fun savePlace(city: String) = PlaceDao.savePlace(city)

    fun getSavedPlace() = PlaceDao.getSavedPlace()

    fun isPlaceSaved() = PlaceDao.isPlaceSaved()

}