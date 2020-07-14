package com.easyinc.currentweather.di.module

import com.easyinc.currentweather.cache.WeatherCache
import com.easyinc.currentweather.data.repository.*
import com.easyinc.currentweather.domain.repository.ILocationRepository
import com.easyinc.currentweather.domain.repository.IWeatherRepository
import com.easyinc.currentweather.remote.api.WeatherRemote
import com.easyinc.currentweather.remote.location.IUserLocation
import com.easyinc.currentweather.remote.location.UserLocation
import com.easyinc.currentweather.remote.location.UserLocationRemote
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun provideUserLocationRemote(userLocationRemote: UserLocationRemote): IUserLocationRemote

    @Binds
    abstract fun provideWeatherCache(weatherCache: WeatherCache): IWeatherCache

    @Binds
    abstract fun provideWeatherRemote(weatherRemote: WeatherRemote): IWeatherRemote

    @Binds
    abstract fun provideWeatherRepository(weatherRepository: WeatherRepository): IWeatherRepository

    @Binds
    abstract fun provideLocationRepository(locationRepository: LocationRepository): ILocationRepository

    @Binds
    abstract fun provideUserLocation(userLocation: UserLocation): IUserLocation

}