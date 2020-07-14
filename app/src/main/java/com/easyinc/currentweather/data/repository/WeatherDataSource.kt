package com.easyinc.currentweather.data.repository

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.google.android.gms.maps.model.LatLng

interface WeatherDataSource {

    suspend fun saveDailyWeatherData(dailyWeatherEntity: DailyWeatherEntity)

    suspend fun saveCurrentlyWeatherData(currentlyWeatherEntity: CurrentlyWeatherEntity)

    suspend fun deleteWeatherData(cityCode: String)

    suspend fun fetchDailyWeatherData(latLng: LatLng?): DailyWeatherEntity

    suspend fun fetchCurrentlyWeatherData(latLng: LatLng?): CurrentlyWeatherEntity

    suspend fun fetchDailyWeatherDataByCity(latLng: LatLng?, cityCode: String?): DailyWeatherEntity

    suspend fun fetchCurrentlyWeatherDataByCity(latLng: LatLng?, cityCode: String?): CurrentlyWeatherEntity

}