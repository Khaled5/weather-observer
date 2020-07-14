package com.easyinc.currentweather.presentation.mapper

import com.easyinc.currentweather.domain.model.DailyWeather
import com.easyinc.currentweather.presentation.model.DailyWeatherView
import javax.inject.Inject

class DailyWeatherViewMapper @Inject constructor(
    private val dailyDataViewMapper: DailyDataViewMapper
): ViewMapper<DailyWeatherView,DailyWeather> {
    override fun mapTo(type: DailyWeather): DailyWeatherView {
        return DailyWeatherView(
            type.data.map {
                dailyDataViewMapper.mapTo(it)
            },
            type.icon,
            type.summary,
            type.city_code
        )
    }
}