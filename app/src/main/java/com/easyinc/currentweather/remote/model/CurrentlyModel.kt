package com.easyinc.currentweather.remote.model

import com.google.gson.annotations.SerializedName

data class CurrentlyModel(
    @SerializedName("apparentTemperature")
    val apparentTemperature: Double,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("temperature")
    val temperature: Double,
    @SerializedName("time")
    val time: Int
)