package com.easyinc.currentweather.domain.model


data class CurrentlyWeather(
    val apparentTemperature: Double,
    val icon: String,
    val summary: String,
    val temperature: Double,
    val time: Int,
    val city_code: String = " "
)