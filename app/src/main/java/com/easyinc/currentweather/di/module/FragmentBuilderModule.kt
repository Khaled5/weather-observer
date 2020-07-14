package com.easyinc.currentweather.di.module

import com.easyinc.currentweather.mobile_ui.home.HomeFragment
import com.easyinc.currentweather.mobile_ui.home.cities.MoscowFragment
import com.easyinc.currentweather.mobile_ui.home.cities.SaintPeterFragment
import com.easyinc.currentweather.mobile_ui.map.MapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun provideMoscowFragment(): MoscowFragment

    @ContributesAndroidInjector
    abstract fun provideSaintPeterFragment(): SaintPeterFragment

    @ContributesAndroidInjector
    abstract fun provideMapFragment(): MapFragment

}