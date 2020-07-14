package com.easyinc.currentweather.domain.model

data class Weather(
    val daily: DailyWeather,
    val currently: CurrentlyWeather
)