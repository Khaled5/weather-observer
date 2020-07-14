package com.easyinc.currentweather.data.mapper

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.domain.model.CurrentlyWeather
import javax.inject.Inject

class CurrentlyWeatherEntityMapper @Inject constructor(): EntityMapper<CurrentlyWeatherEntity,CurrentlyWeather> {

    override fun mapFrom(entity: CurrentlyWeatherEntity): CurrentlyWeather {
        return CurrentlyWeather(
            entity.apparentTemperature,
            entity.icon,
            entity.summary,
            entity.temperature,
            entity.time,
            entity.city_code
        )
    }

    override fun mapTo(entity: CurrentlyWeather): CurrentlyWeatherEntity {
        return CurrentlyWeatherEntity(
            entity.apparentTemperature,
            entity.icon,
            entity.summary,
            entity.temperature,
            entity.time,
            entity.city_code
        )
    }
}