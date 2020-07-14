package com.easyinc.currentweather.remote.model

import com.google.gson.annotations.SerializedName

data class DailyDataModel(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("temperatureMax")
    val temperatureMax: Double,
    @SerializedName("temperatureMin")
    val temperatureMin: Double,
    @SerializedName("time")
    val time: Int
)