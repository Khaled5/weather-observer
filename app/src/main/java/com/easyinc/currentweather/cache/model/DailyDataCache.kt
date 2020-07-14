package com.easyinc.currentweather.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "daily_item_cache")
data class DailyDataCache(
    val daily_item_icon: String = " ",
    val daily_item_summary: String = " ",
    val daily_item_temperatureMax: Double = 0.0,
    val daily_item_temperatureMin: Double = 0.0,
    val daily_item_time: Int = 0,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)