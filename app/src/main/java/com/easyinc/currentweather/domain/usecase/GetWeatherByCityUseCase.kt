package com.easyinc.currentweather.domain.usecase

import com.easyinc.currentweather.domain.model.Weather
import com.easyinc.currentweather.domain.repository.IWeatherRepository
import com.easyinc.currentweather.domain.usecase.base.UseCase
import com.easyinc.currentweather.domain.util.CloudErrorMapper
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class GetWeatherByCityUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val iWeatherRepository: IWeatherRepository
): UseCase<Weather, CityWeather>(errorUtil) {
    override suspend fun executeOnBackground(params: CityWeather?): Weather {
        return iWeatherRepository.getWeatherByCity(params?.latLng,params?.cityCode!!)
    }
}

data class CityWeather(val latLng: LatLng, val cityCode: String)