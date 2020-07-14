package com.easyinc.currentweather.remote.location

import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface IUserLocation {

    suspend fun getUserLocationOnceAsync(): Deferred<LatLng>

}