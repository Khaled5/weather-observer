package com.easyinc.currentweather.common.base

import com.easyinc.currentweather.common.base.viewmodel.factory.ViewModelFactory
import com.easyinc.currentweather.common.base.viewmodel.factory.getViewModel
import com.easyinc.currentweather.common.extentions.androidLazy
import com.easyinc.currentweather.presentation.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity: DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MainViewModel>
    val mainViewModel by androidLazy {
        getViewModel<MainViewModel>(viewModelFactory)
    }

}