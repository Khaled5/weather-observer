package com.easyinc.currentweather.mobile_ui.utils

import com.easyinc.currentweather.R

object TemperatureIcon {



    fun getIcon(weatherState: String): Int{
        return when(weatherState){
            "clear-day" -> R.drawable.sun
            "clear-night" -> R.drawable.clear_night
            "rain" -> R.drawable.rain
            "snow" -> R.drawable.snow
            "sleet" -> R.drawable.sleet
            "wind" -> R.drawable.wind
            "fog" -> R.drawable.fog
            "cloudy" -> R.drawable.cloud
            "partly-cloudy-day" -> R.drawable.partly_cloudy
            "partly-cloudy-night" -> R.drawable.partly_cloudy_night
            else -> R.drawable.sun
        }
    }

}