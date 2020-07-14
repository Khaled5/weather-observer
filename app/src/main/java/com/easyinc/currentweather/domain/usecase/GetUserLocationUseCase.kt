package com.easyinc.currentweather.domain.usecase

import com.easyinc.currentweather.common.network_state.NetworkStateHolder
import com.easyinc.currentweather.domain.repository.ILocationRepository
import com.easyinc.currentweather.domain.usecase.base.UseCase
import com.easyinc.currentweather.domain.util.CloudErrorMapper
import com.google.android.gms.maps.model.LatLng
import java.net.ConnectException
import javax.inject.Inject

class GetUserLocationUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val iLocationRepository: ILocationRepository
): UseCase<LatLng, Unit>(errorUtil) {
    override suspend fun executeOnBackground(params: Unit?): LatLng {
        if (NetworkStateHolder.isConnected)
            return iLocationRepository.getUserLocation()
        else
            throw ConnectException("Check internet connection!")
    }

}