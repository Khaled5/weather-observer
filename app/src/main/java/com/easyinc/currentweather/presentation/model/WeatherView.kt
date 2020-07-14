package com.easyinc.currentweather.presentation.model

data class WeatherView(
    val daily: DailyWeatherView,
    val currently: CurrentlyWeatherView
)