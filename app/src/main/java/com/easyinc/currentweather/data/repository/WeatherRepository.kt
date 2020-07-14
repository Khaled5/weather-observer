package com.easyinc.currentweather.data.repository

import com.easyinc.currentweather.common.network_state.NetworkStateHolder
import com.easyinc.currentweather.data.mapper.CurrentlyWeatherEntityMapper
import com.easyinc.currentweather.data.mapper.DailyWeatherEntityMapper
import com.easyinc.currentweather.data.store.WeatherCacheDataSource
import com.easyinc.currentweather.data.store.WeatherRemoteDataSource
import com.easyinc.currentweather.domain.model.CurrentlyWeather
import com.easyinc.currentweather.domain.model.Weather
import com.easyinc.currentweather.domain.repository.IWeatherRepository
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val iWeatherCache: IWeatherCache,
    private val weatherCacheDataSource: WeatherCacheDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val currentlyWeatherEntityMapper: CurrentlyWeatherEntityMapper,
    private val dailyWeatherEntityMapper: DailyWeatherEntityMapper
): IWeatherRepository {

    override suspend fun getCurrentlyWeather(latLng: LatLng?): CurrentlyWeather {
        return currentlyWeatherEntityMapper.mapFrom(weatherRemoteDataSource.fetchCurrentlyWeatherData(latLng))
    }

    override suspend fun getWeatherByCity(latLng: LatLng?, cityCode: String): Weather {

        return if (iWeatherCache.isWeatherCacheExpired(cityCode) && NetworkStateHolder.isConnected) {
            getWeatherFromApiAndSaveInCache(latLng, cityCode)
        }else {
            getWeatherFromCacheByCity(latLng, cityCode)
        }
    }

    private suspend fun getWeatherFromApiAndSaveInCache(latLng: LatLng?, cityCode: String): Weather{
        val currently = weatherRemoteDataSource.fetchCurrentlyWeatherData(latLng)
        val daily = weatherRemoteDataSource.fetchDailyWeatherData(latLng)

        weatherCacheDataSource.deleteWeatherData(cityCode)
        weatherCacheDataSource.saveCurrentlyWeatherData(
            currently.also {
                it.city_code = cityCode
            }
        )
        weatherCacheDataSource.saveDailyWeatherData(
            daily.also {
                it.city_code = cityCode
            }
        )
        iWeatherCache.setLastCacheTime(System.currentTimeMillis(),cityCode)

        return Weather(
            dailyWeatherEntityMapper.mapFrom(daily),
            currentlyWeatherEntityMapper.mapFrom(currently)
        )
    }

    private suspend fun getWeatherFromCacheByCity(latLng: LatLng?,cityCode: String): Weather{
        val currently = weatherCacheDataSource.fetchCurrentlyWeatherDataByCity(latLng,cityCode)
        val daily = weatherCacheDataSource.fetchDailyWeatherDataByCity(latLng,cityCode)

        return Weather(
            dailyWeatherEntityMapper.mapFrom(daily),
            currentlyWeatherEntityMapper.mapFrom(currently)
        )
    }
}