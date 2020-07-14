package com.easyinc.currentweather.di

import android.app.Application
import com.easyinc.currentweather.WeatherApp
import com.easyinc.currentweather.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class,
    DataModule::class,
    DataSourceModule::class,
    AppModule::class])
interface MainComponent: AndroidInjector<WeatherApp> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MainComponent

    }

}