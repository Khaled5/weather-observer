package com.easyinc.currentweather.data.model



data class DailyWeatherEntity(
    val data: List<DailyDataEntity>,
    val icon: String,
    val summary: String,
    var city_code: String = " "
)