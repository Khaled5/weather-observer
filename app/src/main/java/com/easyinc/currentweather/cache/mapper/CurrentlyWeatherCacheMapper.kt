package com.easyinc.currentweather.cache.mapper

import com.easyinc.currentweather.cache.model.CurrentlyWeatherCache
import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import javax.inject.Inject

class CurrentlyWeatherCacheMapper @Inject constructor(): CacheMapper<CurrentlyWeatherCache,CurrentlyWeatherEntity> {
    override fun mapFromCache(cache: CurrentlyWeatherCache): CurrentlyWeatherEntity {
        return CurrentlyWeatherEntity(
            cache.currently_apparentTemperature,
            cache.currently_icon,
            cache.currently_summary,
            cache.currently_temperature,
            cache.currently_time,
            cache.city_code
        )
    }

    override fun mapToCache(entity: CurrentlyWeatherEntity): CurrentlyWeatherCache {
        return CurrentlyWeatherCache(
            entity.apparentTemperature,
            entity.icon,
            entity.summary,
            entity.temperature,
            entity.time,
            entity.city_code
        )
    }

}