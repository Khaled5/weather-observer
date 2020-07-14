package com.easyinc.currentweather.cache.db

import androidx.room.TypeConverter
import com.easyinc.currentweather.cache.model.DailyDataCache
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DataConverter {
    @TypeConverter
    fun fromCountryLangList(countryLang: List<DailyDataCache?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<DailyDataCache?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): List<DailyDataCache>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<DailyDataCache?>?>() {}.type
        return gson.fromJson<List<DailyDataCache>>(countryLangString, type)
    }
}