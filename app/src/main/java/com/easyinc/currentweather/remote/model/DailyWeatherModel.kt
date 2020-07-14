package com.easyinc.currentweather.remote.model

import com.google.gson.annotations.SerializedName

data class DailyWeatherModel(
    @SerializedName("daily")
    val daily: DailyModel
)