package com.easyinc.currentweather.presentation.model


data class DailyDataWeatherView(
    val icon: String,
    val summary: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val time: Int
)