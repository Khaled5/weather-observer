package com.easyinc.currentweather.di.module

import com.easyinc.currentweather.mobile_ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule  {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}