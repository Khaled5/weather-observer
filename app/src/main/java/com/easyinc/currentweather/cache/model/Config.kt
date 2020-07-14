package com.easyinc.currentweather.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "config")
data class Config (
        val config_lastCacheTime: Long = 100,
        var city_code: String,
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
)