package com.sunnyweather.android.logic.model

import com.sunnyweather.android.R

class SkyNight(val info: String, val icon: Int, val bg: Int) {
}
private val sky = mapOf(
    "00" to SkyNight("晴", R.drawable.ic_clear_night, R.drawable.bg_clear_night),
    "01" to SkyNight("多云", R.drawable.ic_partly_cloud_night, R.drawable.bg_partly_cloudy_night),
    "02" to SkyNight("阴", R.drawable.ic_cloudy, R.drawable.bg_cloudy),
    "03" to SkyNight("阵雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "04" to SkyNight("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "05" to SkyNight("雷阵雨伴有冰雹", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "06" to SkyNight("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain),
    "07" to SkyNight("小雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "08" to SkyNight("中雨", R.drawable.ic_moderate_rain, R.drawable.bg_rain),
    "09" to SkyNight("大雨", R.drawable.ic_heavy_rain, R.drawable.bg_rain),
    "10" to SkyNight("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "11" to SkyNight("大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "12" to SkyNight("特大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "13" to SkyNight("阵雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "14" to SkyNight("小雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "15" to SkyNight("中雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow),
    "16" to SkyNight("大雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "17" to SkyNight("暴雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "18" to SkyNight("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "19" to SkyNight("冻雨", R.drawable.ic_hail, R.drawable.bg_snow),
    "20" to SkyNight("沙尘暴", R.drawable.ic_moderate_haze, R.drawable.bg_fog),
    "21" to SkyNight("小到中雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "22" to SkyNight("中到大雨", R.drawable.ic_moderate_rain, R.drawable.bg_rain),
    "23" to SkyNight("大到暴雨", R.drawable.ic_heavy_rain, R.drawable.bg_rain),
    "24" to SkyNight("暴雨到大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "25" to SkyNight("大暴雨到特大暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "26" to SkyNight("小到中雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "27" to SkyNight("中到大雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow),
    "28" to SkyNight("大到暴雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "29" to SkyNight("浮尘", R.drawable.ic_fog, R.drawable.bg_fog),
    "30" to SkyNight("扬沙", R.drawable.ic_fog, R.drawable.bg_fog),
    "31" to SkyNight("强沙尘暴", R.drawable.ic_heavy_haze, R.drawable.bg_fog),
    "53" to SkyNight("霾", R.drawable.ic_light_haze, R.drawable.bg_fog)
)

fun getSkyNight(widNight: String): SkyNight {
    return sky[widNight]!!
}