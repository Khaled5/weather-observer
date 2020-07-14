package com.easyinc.currentweather.remote.model


import com.google.gson.annotations.SerializedName

data class DailyModel(
    @SerializedName("data")
    val data: List<DailyDataModel>,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("summary")
    val summary: String
)