package com.sunnyweather.android.logic.network

import com.sunnyweather.android.LogUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {

    private val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun searchWeather(city: String) = weatherService.searchWeather(city).await()

    private suspend fun <T> Call<T>.await(): T{
        LogUtil.d("SunnyWeatherNetwork", "weatherService.searchWeather(city).await方法开始执行")
        return suspendCoroutine { continuation ->
            LogUtil.d("SunnyWeatherNetwork", "当前协程已被挂起，在普通线程中执行下面的代码")
            enqueue(object :Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    LogUtil.d("SunnyWeatherNetwork", "已经进入onResponse方法中")
                    val body = response.body()
                    LogUtil.d("SunnyWeatherNetwork", "已获取到response.body")
                    if (body != null) {
                        continuation.resume(body)
                        LogUtil.d("SunnyWeatherNetwork", "body不为空，唤醒协程继续运行")
                    }
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    LogUtil.d("SunnyWeatherNetwork", "已经进入onFailure方法中")
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}