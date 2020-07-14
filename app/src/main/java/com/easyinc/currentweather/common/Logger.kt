package com.easyinc.currentweather.common

import android.util.Log

object Logger {

    private const val TAG = "Weather"

    fun dt(value: String) {
        Log.d(TAG, "Thread Name: ${Thread.currentThread().name} - $value")
    }
}