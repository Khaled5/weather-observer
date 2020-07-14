package com.easyinc.currentweather.presentation.model



data class DailyWeatherView(
    val data: List<DailyDataWeatherView>,
    val icon: String,
    val summary: String,
    val city_code: String = " "
)