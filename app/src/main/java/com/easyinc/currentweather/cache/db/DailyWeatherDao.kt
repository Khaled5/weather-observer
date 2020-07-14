package com.easyinc.currentweather.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyinc.currentweather.cache.model.DailyWeatherCache

@Dao
interface DailyWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDailyWeather(dailyCache: DailyWeatherCache)

    @Query("SELECT * FROM daily_cache WHERE city_code = :cityCode")
    fun getDailyWeatherByCity(cityCode: String): DailyWeatherCache

    @Query("DELETE FROM daily_cache WHERE city_code = :cityCode")
    fun deleteDailyWeather(cityCode: String)

}