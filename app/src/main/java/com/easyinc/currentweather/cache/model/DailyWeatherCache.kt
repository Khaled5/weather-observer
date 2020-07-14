package com.easyinc.currentweather.cache.model

import androidx.room.*


@Entity(tableName = "daily_cache")
data class DailyWeatherCache(
    val daily_data: List<DailyDataCache> = emptyList(),
    val daily_icon: String = " ",
    val daily_summary: String = " ",
    val city_code: String = " ",
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)