package com.easyinc.currentweather.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.easyinc.currentweather.mobile_ui.MainActivity
import com.easyinc.currentweather.presentation.viewmodel.MainViewModel
import com.google.android.gms.maps.model.LatLng
import dagger.android.support.DaggerFragment

abstract class BaseFragment: DaggerFragment() {

    lateinit var mViewModel: MainViewModel
    
    abstract fun layoutId(): Int

    lateinit var mainActivity : MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainActivity = activity as MainActivity
        return inflater.inflate(layoutId(), container, false)
    }

    companion object{
        val MOSCOW_LATLNG = LatLng(55.753913, 37.620836)
        val SAINT_PETER_LATLNG = LatLng(59.950015, 30.316599)

        val MOSCOW_CODE = "MS"
        val SAINT_PETER_CODE = "SP"
    }

}