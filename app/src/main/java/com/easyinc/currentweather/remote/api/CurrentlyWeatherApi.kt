package com.easyinc.currentweather.remote.api

import com.easyinc.currentweather.remote.model.CurrentlyWeatherModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrentlyWeatherApi {

    @GET("{key}/{latitude},{longitude}")
    fun getCurrentlyWeatherAsync(
        @Path("latitude") latitude : String,
        @Path("longitude") longitude: String,
        @Path("key") key: String = Constants.API_KEY,
        @Query("lang") lang: String = Constants.DEFAULT_LANGUAGE): Deferred<CurrentlyWeatherModel>

}