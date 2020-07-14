package com.easyinc.currentweather.data.repository

import com.google.android.gms.maps.model.LatLng

interface IUserLocationRemote {

    suspend fun getUserLocation(): LatLng

}