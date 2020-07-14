package com.easyinc.currentweather.remote.api

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.easyinc.currentweather.data.repository.IWeatherRemote
import com.easyinc.currentweather.remote.mapper.CurrentlyWeatherModelMapper
import com.easyinc.currentweather.remote.mapper.DailyWeatherModelMapper
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRemote @Inject constructor(
    private val currentlyWeatherApi: CurrentlyWeatherApi,
    private val currentlyWeatherModelMapper: CurrentlyWeatherModelMapper,
    private val dailyWeatherApi: DailyWeatherApi,
    private val dailyWeatherModelMapper: DailyWeatherModelMapper
): IWeatherRemote {
    override suspend fun getCurrentlyWeather(latLng: LatLng): CurrentlyWeatherEntity {

        return currentlyWeatherModelMapper
            .mapFromModel(
                currentlyWeatherApi.
                getCurrentlyWeatherAsync(latLng.latitude.toString(),latLng.longitude.toString())
                    .await()
            )
    }

    override suspend fun getDailyWeather(latLng: LatLng): DailyWeatherEntity {
        return dailyWeatherModelMapper
            .mapFromModel(
                dailyWeatherApi.
                getDailyWeatherAsync(latLng.latitude.toString(),latLng.longitude.toString())
                    .await()
            )
    }


}