package com.easyinc.currentweather.presentation.model


data class CurrentlyWeatherView(
    val apparentTemperature: Double,
    val icon: String,
    val summary: String,
    val temperature: Double,
    val time: Int,
    val city_code: String = " "
)