package com.easyinc.currentweather.data.model


data class CurrentlyWeatherEntity(
    val apparentTemperature: Double,
    val icon: String,
    val summary: String,
    val temperature: Double,
    val time: Int,
    var city_code: String = " "
)