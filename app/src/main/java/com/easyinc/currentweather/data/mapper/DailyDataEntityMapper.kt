package com.easyinc.currentweather.data.mapper

import com.easyinc.currentweather.data.model.DailyDataEntity
import com.easyinc.currentweather.domain.model.DailyDataWeather
import javax.inject.Inject

class DailyDataEntityMapper @Inject constructor(): EntityMapper<DailyDataEntity, DailyDataWeather> {
    override fun mapFrom(entity: DailyDataEntity): DailyDataWeather {
        return DailyDataWeather(
            entity.icon,
            entity.summary,
            entity.temperatureMax,
            entity.temperatureMin,
            entity.time
        )
    }

    override fun mapTo(entity: DailyDataWeather): DailyDataEntity {
        return DailyDataEntity(
            entity.icon,
            entity.summary,
            entity.temperatureMax,
            entity.temperatureMin,
            entity.time
        )
    }
}