package com.easyinc.currentweather.remote.mapper

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.remote.model.CurrentlyWeatherModel
import javax.inject.Inject

class CurrentlyWeatherModelMapper @Inject constructor(): ModelMapper<CurrentlyWeatherModel,CurrentlyWeatherEntity> {
    override fun mapFromModel(model: CurrentlyWeatherModel): CurrentlyWeatherEntity {
        return CurrentlyWeatherEntity(
            model.currently.apparentTemperature,
            model.currently.icon,
            model.currently.summary,
            model.currently.temperature,
            model.currently.time
        )
    }
}