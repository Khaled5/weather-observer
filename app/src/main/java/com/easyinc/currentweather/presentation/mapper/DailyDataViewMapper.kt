package com.easyinc.currentweather.presentation.mapper

import com.easyinc.currentweather.domain.model.DailyDataWeather
import com.easyinc.currentweather.presentation.model.DailyDataWeatherView
import javax.inject.Inject

class DailyDataViewMapper @Inject constructor(): ViewMapper<DailyDataWeatherView, DailyDataWeather> {
    override fun mapTo(type : DailyDataWeather): DailyDataWeatherView {
        return DailyDataWeatherView(
            type.icon,
            type.summary,
            type.temperatureMax,
            type.temperatureMin,
            type.time
        )
    }

}