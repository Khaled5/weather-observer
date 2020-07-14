package com.easyinc.currentweather.data.model


data class DailyDataEntity(
    val icon: String,
    val summary: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val time: Int
)