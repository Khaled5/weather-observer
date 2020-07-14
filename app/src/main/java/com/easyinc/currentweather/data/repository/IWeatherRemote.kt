package com.easyinc.currentweather.data.repository

import com.easyinc.currentweather.data.model.CurrentlyWeatherEntity
import com.easyinc.currentweather.data.model.DailyWeatherEntity
import com.google.android.gms.maps.model.LatLng

interface IWeatherRemote  {

    suspend fun getCurrentlyWeather(latLng: LatLng): CurrentlyWeatherEntity

    suspend fun getDailyWeather(latLng: LatLng): DailyWeatherEntity

}