package com.easyinc.currentweather.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyinc.currentweather.cache.model.CurrentlyWeatherCache

@Dao
interface CurrentlyWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCurrentlyWeather(dailyCache: CurrentlyWeatherCache)

    @Query("SELECT * FROM currently_cache WHERE city_code = :cityCode")
    fun getCurrentlyWeatherByCity(cityCode: String): CurrentlyWeatherCache

    @Query("DELETE FROM currently_cache WHERE city_code = :cityCode")
    fun deleteCurrentlyWeather(cityCode: String)

}