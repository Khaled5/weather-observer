package com.easyinc.currentweather.domain.model


data class DailyDataWeather(
    val icon: String,
    val summary: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val time: Int
)