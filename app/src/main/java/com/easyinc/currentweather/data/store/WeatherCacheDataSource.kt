package com.easyinc.currentweather.data.store

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.easyinc.currentweather.data.repository.WeatherDataSource
import com.easyinc.currentweather.data.repository.IWeatherCache
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class WeatherCacheDataSource @Inject constructor(
    private val iWeatherCache: IWeatherCache
): WeatherDataSource {

    override suspend fun saveDailyWeatherData(dailyWeatherEntity: DailyWeatherEntity) {
        return iWeatherCache.addDailyWeather(dailyWeatherEntity)
    }

    override suspend fun saveCurrentlyWeatherData(currentlyWeatherEntity: CurrentlyWeatherEntity) {
        return iWeatherCache.addCurrentlyWeather(currentlyWeatherEntity)
    }

    override suspend fun deleteWeatherData(cityCode: String) {
        iWeatherCache.deleteCurrentlyWeather(cityCode)
        iWeatherCache.deleteDailyWeather(cityCode)
    }

    override suspend fun fetchDailyWeatherData(latLng: LatLng?): DailyWeatherEntity {
        throw UnsupportedOperationException("fetchDailyWeatherData is not supported here.")
    }

    override suspend fun fetchCurrentlyWeatherData(latLng: LatLng?): CurrentlyWeatherEntity {
        throw UnsupportedOperationException("fetchCurrentlyWeatherData is not supported here.")
    }

    override suspend fun fetchDailyWeatherDataByCity(
        latLng: LatLng?,
        cityCode: String?
    ): DailyWeatherEntity {
        return iWeatherCache.getDailyWeatherByCity(cityCode!!)
    }

    override suspend fun fetchCurrentlyWeatherDataByCity(
        latLng: LatLng?,
        cityCode: String?
    ): CurrentlyWeatherEntity {
        return iWeatherCache.getCurrentlyWeatherByCity(cityCode!!)
    }
}