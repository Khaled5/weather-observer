package com.easyinc.currentweather.data.repository

import com.easyinc.currentweather.domain.repository.ILocationRepository
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val iUserLocationRemote: IUserLocationRemote
): ILocationRepository {
    override suspend fun getUserLocation(): LatLng {
        return iUserLocationRemote.getUserLocation()
    }
}