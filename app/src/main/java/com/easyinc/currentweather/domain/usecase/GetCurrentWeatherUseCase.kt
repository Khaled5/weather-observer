package com.easyinc.currentweather.domain.usecase

import com.easyinc.currentweather.common.network_state.NetworkStateHolder
import com.easyinc.currentweather.domain.model.CurrentlyWeather
import com.easyinc.currentweather.domain.model.Weather
import com.easyinc.currentweather.domain.repository.IWeatherRepository
import com.easyinc.currentweather.domain.usecase.base.UseCase
import com.easyinc.currentweather.domain.util.CloudErrorMapper
import com.google.android.gms.maps.model.LatLng
import java.net.ConnectException
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val iWeatherRepository: IWeatherRepository
): UseCase<CurrentlyWeather, LatLng>(errorUtil) {
    override suspend fun executeOnBackground(params: LatLng?): CurrentlyWeather {
        if (NetworkStateHolder.isConnected)
            return iWeatherRepository.getCurrentlyWeather(params)
        else
            throw ConnectException("Check internet connection!")
    }
}