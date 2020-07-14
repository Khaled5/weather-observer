package com.easyinc.currentweather.remote.api

import com.easyinc.currentweather.remote.model.DailyWeatherModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DailyWeatherApi {

    @GET("{key}/{latitude},{longitude}")
    fun getDailyWeatherAsync(
        @Path("latitude") latitude : String,
        @Path("longitude") longitude: String,
        @Path("key") key: String = Constants.API_KEY,
        @Query("lang") lang: String = Constants.DEFAULT_LANGUAGE): Deferred<DailyWeatherModel>

}