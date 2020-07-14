package com.easyinc.currentweather.remote.mapper

import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.easyinc.currentweather.remote.model.DailyWeatherModel
import javax.inject.Inject

class DailyWeatherModelMapper @Inject constructor(private val dailyDataMapper: DailyDataMapper): ModelMapper<DailyWeatherModel,DailyWeatherEntity> {
    override fun mapFromModel(model: DailyWeatherModel): DailyWeatherEntity {
        return DailyWeatherEntity(
            model.daily.data.map {
                dailyDataMapper.mapFromModel(it)
            },model.daily.icon,
            model.daily.summary

        )
    }
}