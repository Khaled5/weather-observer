package com.easyinc.currentweather.remote.location

import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.RuntimeExecutionException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserLocation @Inject constructor(context: Context): IUserLocation {

    private val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    override suspend fun getUserLocationOnceAsync(): Deferred<LatLng> {
        return suspendCoroutine {cont ->
            try {
                val userLastLocation = fusedLocationProviderClient.lastLocation
                userLastLocation.addOnCompleteListener {locationTask ->
                    try {
                        val locationResult = locationTask.result
                        val lat = locationResult?.latitude
                        val long = locationResult?.longitude
                        if (lat != null && long != null) {
                            cont.resume(
                                CompletableDeferred(
                                    LatLng(lat, long)
                                )
                            )
                        }
                    }catch (e: Exception) {
                        cont.resume(
                            CompletableDeferred(
                                LatLng(0.0,0.0)
                            )
                        )
                    }
                }
            }catch (e: SecurityException) {
                throw SecurityException("Lost location permissions. Couldn't remove updates")
            }
        }
    }
}