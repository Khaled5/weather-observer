package com.easyinc.currentweather

import com.easyinc.currentweather.common.network_state.NetworkStateHolder.registerConnectivityBroadcaster
import com.easyinc.currentweather.di.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class WeatherApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        registerConnectivityBroadcaster()
    }
}