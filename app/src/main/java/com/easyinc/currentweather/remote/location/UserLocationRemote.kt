package com.easyinc.currentweather.remote.location

import com.easyinc.currentweather.data.repository.IUserLocationRemote
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class UserLocationRemote @Inject constructor(
    private val iUserLocation: IUserLocation
): IUserLocationRemote {
    override suspend fun getUserLocation(): LatLng {
        return iUserLocation.getUserLocationOnceAsync().await()
    }
}