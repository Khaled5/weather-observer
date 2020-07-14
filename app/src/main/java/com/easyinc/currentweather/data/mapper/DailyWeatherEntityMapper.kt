package com.easyinc.currentweather.data.mapper

import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.easyinc.currentweather.domain.model.DailyWeather
import javax.inject.Inject

class DailyWeatherEntityMapper @Inject constructor(
    private val dailyDataEntityMapper: DailyDataEntityMapper
): EntityMapper<DailyWeatherEntity,DailyWeather> {
    override fun mapFrom(entity: DailyWeatherEntity): DailyWeather {
        return DailyWeather(
            entity.data.map {
                dailyDataEntityMapper.mapFrom(it)
            },entity.icon,
            entity.summary,
            entity.city_code
        )
    }

    override fun mapTo(entity: DailyWeather): DailyWeatherEntity {
        return DailyWeatherEntity(
            entity.data.map {
                dailyDataEntityMapper.mapTo(it)
            },entity.icon,
            entity.summary,
            entity.city_code
        )
    }
}