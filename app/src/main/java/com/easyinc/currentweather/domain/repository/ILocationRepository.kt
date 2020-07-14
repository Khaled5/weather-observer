package com.easyinc.currentweather.domain.repository

import com.google.android.gms.maps.model.LatLng

interface ILocationRepository {

    suspend fun getUserLocation(): LatLng

}