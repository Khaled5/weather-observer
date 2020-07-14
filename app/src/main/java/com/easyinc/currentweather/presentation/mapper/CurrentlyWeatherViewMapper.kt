package com.easyinc.currentweather.presentation.mapper

import com.easyinc.currentweather.domain.model.CurrentlyWeather
import com.easyinc.currentweather.presentation.model.CurrentlyWeatherView
import javax.inject.Inject

class CurrentlyWeatherViewMapper @Inject constructor(): ViewMapper<CurrentlyWeatherView, CurrentlyWeather> {
    override fun mapTo(type: CurrentlyWeather): CurrentlyWeatherView {
        return CurrentlyWeatherView(
            type.apparentTemperature,
            type.icon,
            type.summary,
            type.temperature,
            type.time,
            type.city_code
        )
    }
}