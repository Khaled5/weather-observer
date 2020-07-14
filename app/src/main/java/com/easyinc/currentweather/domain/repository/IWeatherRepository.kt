package com.easyinc.currentweather.domain.repository

import com.easyinc.currentweather.domain.model.CurrentlyWeather
import com.easyinc.currentweather.domain.model.Weather
import com.google.android.gms.maps.model.LatLng

interface IWeatherRepository {

    suspend fun getWeatherByCity(latLng: LatLng?, cityCode: String): Weather

    suspend fun getCurrentlyWeather(latLng: LatLng?): CurrentlyWeather

}