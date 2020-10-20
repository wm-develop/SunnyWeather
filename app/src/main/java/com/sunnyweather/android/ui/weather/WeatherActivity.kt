package com.sunnyweather.android.ui.weather

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunnyweather.android.DateUtil
import com.sunnyweather.android.LogUtil
import com.sunnyweather.android.R
import com.sunnyweather.android.logic.model.WeatherResponse
import com.sunnyweather.android.logic.model.getSky
import com.sunnyweather.android.logic.model.getSkyNight
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.forecast.*
import kotlinx.android.synthetic.main.forecast_item.view.*
import kotlinx.android.synthetic.main.now.*
import java.util.*

class WeatherActivity : AppCompatActivity() {

    val viewModel by lazy { ViewModelProvider(this).get(WeatherViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_weather)
        if (viewModel.city.isEmpty()) {
            viewModel.city = intent.getStringExtra("city") ?: ""
        }
        viewModel.weatherLiveData.observe(this, Observer { result ->
            val weather = result.getOrNull()
            if (weather != null) {
                showWeatherInfo(weather)
            } else {
                Toast.makeText(this, "无法成功获取天气信息", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })
        viewModel.refreshWeather(viewModel.city)
    }

    private fun showWeatherInfo(weather: WeatherResponse) {
        placeName.text = viewModel.city
        val realtime = weather.result.realtime
        //填充now.xml
        currentTemp.text = "${realtime.temperature}℃"
        currentSky.text = getSky(realtime.wid).info
        currentAQI.text = "空气指数 ${realtime.aqi}"
        if (DateUtil.getNowTime().substring(0, 2).toInt() >= 18) {
            LogUtil.d("WeatherActivity", "当前时间是${DateUtil.getNowTime()}")
            nowLayout.setBackgroundResource(getSky(realtime.wid).bg)
        } else {
            nowLayout.setBackgroundResource(getSkyNight(realtime.wid).bg)
        }
        //填充forecast.xml
        forecastLayout.removeAllViews()
        val size = weather.result.future.size
        for (i in 0 until size) {
            val future = weather.result.future[i]
            val view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false)
            val dateInfo = view.dateInfo as TextView
            val skyIcon = view.skyIcon as ImageView
            val skyInfo = view.skyInfo as TextView
            val temperatureInfo = view.temperatureInfo as TextView
            dateInfo.text = future.date
            skyIcon.setImageResource(getSky(future.wid.day).icon)
            skyInfo.text = future.weather
            temperatureInfo.text = future.temperature
            forecastLayout.addView(view)
        }
        weatherLayout.visibility = View.VISIBLE
    }
}