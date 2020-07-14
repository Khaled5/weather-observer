package com.easyinc.currentweather.mobile_ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.easyinc.currentweather.R
import com.easyinc.currentweather.cache.db.AppDatabase
import com.easyinc.currentweather.common.base.BaseFragment
import com.easyinc.currentweather.mobile_ui.MainActivity
import com.easyinc.currentweather.mobile_ui.home.adapter.ViewPagerFragmentAdapter
import com.easyinc.currentweather.mobile_ui.home.cities.MoscowFragment
import com.easyinc.currentweather.mobile_ui.home.cities.SaintPeterFragment
import com.easyinc.currentweather.mobile_ui.utils.TemperatureIcon
import com.easyinc.currentweather.presentation.model.CurrentlyWeatherView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.choosed_city_weather_raw.*
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : BaseFragment() {
    private lateinit var viewPagerAdapter: ViewPagerFragmentAdapter

    @Inject lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = (activity as MainActivity).mainViewModel

    }

    override fun layoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()

        observeCurrentWeather()

    }

    private fun initViewPager(){
        viewPagerAdapter =
            ViewPagerFragmentAdapter(
                requireActivity()
            )

        viewPagerAdapter.addFragment(MoscowFragment())
        viewPagerAdapter.addFragment(SaintPeterFragment())
        viewpager.adapter = viewPagerAdapter

        TabLayoutMediator(tabs, viewpager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> { tab.text = resources.getString(R.string.moscow)}
                    1 -> { tab.text = resources.getString(R.string.saint_peter)}
                }
            }).attach()
    }

    private fun observeCurrentWeather(){
        mViewModel.observeCurrentWeather().observe(viewLifecycleOwner, Observer {
            drawData(it)
        })
    }

    private fun drawData(currentlyWeatherView: CurrentlyWeatherView){
        main_temp.text = (currentlyWeatherView.temperature.minus(32) / 1.8).toInt().toString().plus(resources.getString(R.string.celsius))
        main_state.text = currentlyWeatherView.summary
        main_icon.setImageResource(TemperatureIcon.getIcon(currentlyWeatherView.icon))
    }

}