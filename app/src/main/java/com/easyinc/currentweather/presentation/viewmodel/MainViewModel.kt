package com.easyinc.currentweather.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.easyinc.currentweather.common.Resource
import com.easyinc.currentweather.common.base.viewmodel.BaseViewModel
import com.easyinc.currentweather.domain.usecase.*
import com.easyinc.currentweather.presentation.functionality.SingleLiveEvent
import com.easyinc.currentweather.presentation.mapper.CurrentlyWeatherViewMapper
import com.easyinc.currentweather.presentation.mapper.WeatherViewMapper
import com.easyinc.currentweather.presentation.model.CurrentlyWeatherView
import com.easyinc.currentweather.presentation.model.WeatherView
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUserLocationUseCase: GetUserLocationUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getWeatherByCityUseCase: GetWeatherByCityUseCase,
    private val currentlyWeatherViewMapper: CurrentlyWeatherViewMapper,
    private val weatherViewMapper: WeatherViewMapper
): BaseViewModel() {

    private val userLocation by lazy { SingleLiveEvent<LatLng>() }
    private val mapCurrentlyWeather by lazy { SingleLiveEvent<CurrentlyWeatherView>() }
    private val currentlyWeather by lazy { MutableLiveData<CurrentlyWeatherView>() }
    private val weather by lazy { MutableLiveData<WeatherView>() }

    fun observeUserLocation(): LiveData<LatLng> = userLocation
    fun observeCurrentWeather(): LiveData<CurrentlyWeatherView> = currentlyWeather
    fun observeMapCurrentWeather(): LiveData<CurrentlyWeatherView> = mapCurrentlyWeather
    fun observeWeather(): LiveData<WeatherView> = weather

    fun getUserLocation(){
        getUserLocationUseCase.execute{
            onComplete {
                userLocation.value = it
            }

            onError {
                message.value = it.message?.let { msg -> Resource.Error(msg) }
            }

            onCancel {  }
        }
    }

    fun getMapCurrentWeather(latLng: LatLng){
        getCurrentWeatherUseCase.execute(latLng) {
            onComplete {
                mapCurrentlyWeather.value = currentlyWeatherViewMapper.mapTo(it)
            }

            onError {
                message.value = it.message?.let { msg -> Resource.Error(msg) }
            }

            onCancel {  }
        }
    }

    fun getWeatherByCity(latLng: LatLng, cityCode: String){
        getWeatherByCityUseCase.execute(CityWeather(latLng,cityCode)) {
            onComplete {
                weather.value = weatherViewMapper.mapTo(it)
                currentlyWeather.value = currentlyWeatherViewMapper.mapTo(it.currently)
            }

            onError {
                message.value = it.message?.let { msg -> Resource.Error(msg) }
            }

            onCancel {  }
        }
    }

    // Clear
    override fun onCleared() {
        super.onCleared()
        getUserLocationUseCase.unsubscribe()
        getCurrentWeatherUseCase.unsubscribe()
        getWeatherByCityUseCase.unsubscribe()
    }

}