package com.easyinc.currentweather.common.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyinc.currentweather.common.Resource
import com.easyinc.currentweather.presentation.functionality.SingleLiveEvent

open class BaseViewModel constructor() : ViewModel() {
    val message by lazy { SingleLiveEvent<Resource<String>>() }

    fun observeError(): LiveData<Resource<String>> = message
}