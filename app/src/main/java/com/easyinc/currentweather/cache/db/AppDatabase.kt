package com.easyinc.currentweather.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.easyinc.currentweather.cache.model.Config
import com.easyinc.currentweather.cache.model.CurrentlyWeatherCache
import com.easyinc.currentweather.cache.model.DailyWeatherCache
import com.easyinc.currentweather.cache.model.DailyDataCache

@Database(
    entities = [DailyDataCache::class,DailyWeatherCache::class,CurrentlyWeatherCache::class, Config::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun currentlyWeatherDao(): CurrentlyWeatherDao

    abstract fun dailyWeatherDao(): DailyWeatherDao

    abstract fun configWeatherDao(): ConfigDao

}