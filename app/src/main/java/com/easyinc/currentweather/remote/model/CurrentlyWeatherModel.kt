package com.easyinc.currentweather.remote.model

import com.google.gson.annotations.SerializedName

data class CurrentlyWeatherModel(
    @SerializedName("currently")
    val currently: CurrentlyModel
)