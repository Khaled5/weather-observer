package com.easyinc.currentweather.domain.model



data class DailyWeather(
    val data: List<DailyDataWeather>,
    val icon: String,
    val summary: String,
    val city_code: String = " "
)