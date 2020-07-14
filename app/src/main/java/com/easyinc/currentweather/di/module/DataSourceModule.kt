package com.easyinc.currentweather.di.module

import android.content.Context
import androidx.room.Room
import com.easyinc.currentweather.cache.db.AppDatabase
import com.easyinc.currentweather.remote.api.CurrentlyWeatherApi
import com.easyinc.currentweather.remote.api.DailyWeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase{
        return Room
            .databaseBuilder(context,AppDatabase::class.java, "weather_db")
            .build()
    }

    @Provides
    fun provideCurrentWeatherApi(retrofit: Retrofit): CurrentlyWeatherApi{
        return retrofit.create(CurrentlyWeatherApi::class.java)
    }

    @Provides
    fun provideDailyWeatherApi(retrofit: Retrofit): DailyWeatherApi{
        return retrofit.create(DailyWeatherApi::class.java)
    }

}