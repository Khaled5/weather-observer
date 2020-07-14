package com.easyinc.currentweather.cache

import com.easyinc.currentweather.cache.db.AppDatabase
import com.easyinc.currentweather.cache.mapper.CurrentlyWeatherCacheMapper
import com.easyinc.currentweather.cache.mapper.DailyWeatherCacheMapper
import com.easyinc.currentweather.cache.model.Config
import com.easyinc.currentweather.common.extentions.isExpired
import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.easyinc.currentweather.data.repository.IWeatherCache
import javax.inject.Inject

class WeatherCache @Inject constructor(
    private val appDatabase: AppDatabase,
    private val currentlyWeatherCacheMapper: CurrentlyWeatherCacheMapper,
    private val dailyWeatherCacheMapper: DailyWeatherCacheMapper
): IWeatherCache {
    override suspend fun setLastCacheTime(lastCache: Long,cityCode: String) {
        return appDatabase.configWeatherDao().insertConfig(Config(lastCache,cityCode))
    }

    override suspend fun isWeatherCacheExpired(cityCode: String): Boolean {
        val lastCacheTimeResult = kotlin.runCatching { appDatabase.configWeatherDao().getConfig(cityCode).config_lastCacheTime }

        return when(lastCacheTimeResult.isSuccess){
             true -> lastCacheTimeResult.getOrNull()?.isExpired()!!
            false -> true
        }

    }

    override suspend fun getCurrentlyWeatherByCity(cityCode: String): CurrentlyWeatherEntity {
        return currentlyWeatherCacheMapper.mapFromCache(
            appDatabase.currentlyWeatherDao().getCurrentlyWeatherByCity(cityCode)
        )
    }

    override suspend fun addCurrentlyWeather(currentlyWeatherEntity: CurrentlyWeatherEntity) {
        return appDatabase.currentlyWeatherDao().addCurrentlyWeather(currentlyWeatherCacheMapper.mapToCache(currentlyWeatherEntity))
    }

    override suspend fun deleteCurrentlyWeather(cityCode: String) {
        return appDatabase.currentlyWeatherDao().deleteCurrentlyWeather(cityCode)
    }

    override suspend fun getDailyWeatherByCity(cityCode: String): DailyWeatherEntity {
        return dailyWeatherCacheMapper.mapFromCache(
            appDatabase.dailyWeatherDao().getDailyWeatherByCity(cityCode)
        )
    }

    override suspend fun addDailyWeather(dailyWeatherEntity: DailyWeatherEntity) {
        return appDatabase.dailyWeatherDao().addDailyWeather(dailyWeatherCacheMapper.mapToCache(dailyWeatherEntity))
    }

    override suspend fun deleteDailyWeather(cityCode: String) {
        return appDatabase.dailyWeatherDao().deleteDailyWeather(cityCode)
    }
}