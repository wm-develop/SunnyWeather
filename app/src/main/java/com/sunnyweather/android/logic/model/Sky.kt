package com.sunnyweather.android.logic.model

import com.sunnyweather.android.R

class Sky(val info: String, val icon: Int, val bg: Int) {
}
private val sky = mapOf(
    "00" to Sky("晴", R.drawable.ic_clear_day, R.drawable.bg_clear_day),
    "01" to Sky("多云", R.drawable.ic_partly_cloud_day, R.drawable.bg_partly_cloudy_day),
    "02" to Sky("阴", R.drawable.ic_cloudy, R.drawable.bg_cloudy),
    "03" to Sky("阵雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "04" to Sky("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "05" to Sky("雷阵雨伴有冰雹", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "06" to Sky("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain),
    "07" to Sky("小雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "08" to Sky("中雨", R.drawable.ic_moderate_rain, R.drawable.bg_rain),
    "09" to Sky("大雨", R.drawable.ic_heavy_rain, R.drawable.bg_rain),
    "10" to Sky("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "11" to Sky("大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "12" to Sky("特大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "13" to Sky("阵雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "14" to Sky("小雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "15" to Sky("中雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow),
    "16" to Sky("大雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "17" to Sky("暴雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "18" to Sky("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "19" to Sky("冻雨", R.drawable.ic_hail, R.drawable.bg_snow),
    "20" to Sky("沙尘暴", R.drawable.ic_moderate_haze, R.drawable.bg_fog),
    "21" to Sky("小到中雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "22" to Sky("中到大雨", R.drawable.ic_moderate_rain, R.drawable.bg_rain),
    "23" to Sky("大到暴雨", R.drawable.ic_heavy_rain, R.drawable.bg_rain),
    "24" to Sky("暴雨到大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "25" to Sky("大暴雨到特大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "26" to Sky("小到中雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "27" to Sky("中到大雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow),
    "28" to Sky("大到暴雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "29" to Sky("浮尘", R.drawable.ic_fog, R.drawable.bg_fog),
    "30" to Sky("扬沙", R.drawable.ic_fog, R.drawable.bg_fog),
    "31" to Sky("强沙尘暴", R.drawable.ic_heavy_haze, R.drawable.bg_fog),
    "53" to Sky("霾", R.drawable.ic_light_haze, R.drawable.bg_fog)
)

fun getSky(widDay: String): Sky {
    return sky[widDay]!!
}