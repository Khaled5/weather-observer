package com.easyinc.currentweather.data.repository

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.data.model.DailyWeatherEntity

interface IWeatherCache  {

    suspend fun setLastCacheTime(lastCache: Long, cityCode: String)

    suspend fun isWeatherCacheExpired(cityCode: String): Boolean

    suspend fun getCurrentlyWeatherByCity(cityCode: String): CurrentlyWeatherEntity

    suspend fun addCurrentlyWeather(currentlyWeatherEntity: CurrentlyWeatherEntity)

    suspend fun deleteCurrentlyWeather(cityCode: String)

    suspend fun getDailyWeatherByCity(cityCode: String): DailyWeatherEntity

    suspend fun addDailyWeather(dailyWeatherEntity: DailyWeatherEntity)

    suspend fun deleteDailyWeather(cityCode: String)
}