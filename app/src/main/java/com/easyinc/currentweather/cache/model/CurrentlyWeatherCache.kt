package com.easyinc.currentweather.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "currently_cache")
data class CurrentlyWeatherCache(
    val currently_apparentTemperature: Double = 0.0,
    val currently_icon: String = " ",
    val currently_summary: String = " ",
    val currently_temperature: Double = 0.0,
    val currently_time: Int = 0,
    val city_code: String = " ",
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)