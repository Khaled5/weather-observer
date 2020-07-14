package com.easyinc.currentweather.mobile_ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.easyinc.currentweather.R
import com.easyinc.currentweather.common.base.BaseActivity
import com.easyinc.currentweather.common.extentions.snack
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navController = findNavController(R.id.nav_host_fragment)
        bottomNavigation.setupWithNavController(navController)

        observeErrorMessage()

    }

    fun hideProgressBar(hide: Boolean){
        main_temp_progress.visibility = if (hide) View.GONE else View.VISIBLE
    }

    private fun observeErrorMessage(){
        mainViewModel.observeError().observe(this, Observer {
            it.message?.let { msg -> weather_snack.snack(msg) }
        })
    }


}