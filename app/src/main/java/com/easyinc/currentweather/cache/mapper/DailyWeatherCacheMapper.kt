package com.easyinc.currentweather.cache.mapper

import com.easyinc.currentweather.cache.model.DailyWeatherCache
import com.easyinc.currentweather.data.model.DailyWeatherEntity
import javax.inject.Inject

class DailyWeatherCacheMapper @Inject constructor(private val dailyDataMapper: DailyDataMapper): CacheMapper<DailyWeatherCache,DailyWeatherEntity> {
    override fun mapFromCache(cache: DailyWeatherCache): DailyWeatherEntity {
        return DailyWeatherEntity(
            cache.daily_data.map {
                dailyDataMapper.mapFromCache(it)
            }
            ,cache.daily_icon,
            cache.daily_summary,
            cache.city_code

        )
    }

    override fun mapToCache(entity: DailyWeatherEntity): DailyWeatherCache {
        return DailyWeatherCache(
            entity.data.map {
                dailyDataMapper.mapToCache(it)
            },entity.icon,
            entity.summary,
            entity.city_code
        )
    }

}