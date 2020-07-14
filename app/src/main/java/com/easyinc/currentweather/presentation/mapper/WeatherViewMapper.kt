package com.easyinc.currentweather.presentation.mapper

import com.easyinc.currentweather.domain.model.Weather
import com.easyinc.currentweather.presentation.model.WeatherView
import javax.inject.Inject

class WeatherViewMapper @Inject constructor(
    private val dailyWeatherViewMapper: DailyWeatherViewMapper,
    private val currentlyWeatherViewMapper: CurrentlyWeatherViewMapper
): ViewMapper<WeatherView,Weather> {
    override fun mapTo(type: Weather): WeatherView {
        return WeatherView(
            dailyWeatherViewMapper.mapTo(type.daily),
            currentlyWeatherViewMapper.mapTo(type.currently))
    }
}