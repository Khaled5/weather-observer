package com.easyinc.currentweather.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyinc.currentweather.cache.model.Config

@Dao
interface ConfigDao {

    @Query("SELECT * FROM config WHERE city_code = :city_code")
    fun getConfig(city_code: String) : Config

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertConfig(config: Config)

}