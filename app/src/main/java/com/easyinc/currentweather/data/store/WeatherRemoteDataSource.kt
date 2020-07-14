package com.easyinc.currentweather.data.store

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.easyinc.currentweather.data.repository.WeatherDataSource
import com.easyinc.currentweather.data.repository.IWeatherRemote
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val iWeatherRemote: IWeatherRemote
): WeatherDataSource {

    override suspend fun saveDailyWeatherData(dailyWeatherEntity: DailyWeatherEntity) {
       throw UnsupportedOperationException("saveDailyWeatherData is not supported here.")
    }

    override suspend fun saveCurrentlyWeatherData(currentlyWeatherEntity: CurrentlyWeatherEntity) {
        throw UnsupportedOperationException("saveCurrentlyWeatherData is not supported here.")
    }

    override suspend fun deleteWeatherData(cityCode: String) {
        throw UnsupportedOperationException("deleteWeatherData is not supported here.")
    }

    override suspend fun fetchDailyWeatherData(latLng: LatLng?): DailyWeatherEntity {
        return iWeatherRemote.getDailyWeather(latLng!!)
    }

    override suspend fun fetchCurrentlyWeatherData(latLng: LatLng?): CurrentlyWeatherEntity {
        return iWeatherRemote.getCurrentlyWeather(latLng!!)
    }

    override suspend fun fetchDailyWeatherDataByCity(
        latLng: LatLng?,
        cityCode: String?
    ): DailyWeatherEntity {
        throw UnsupportedOperationException("fetchDailyWeatherDataByCity is not supported here.")
    }

    override suspend fun fetchCurrentlyWeatherDataByCity(
        latLng: LatLng?,
        cityCode: String?
    ): CurrentlyWeatherEntity {
        throw UnsupportedOperationException("fetchCurrentlyWeatherDataByCity is not supported here.")
    }
}