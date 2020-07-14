package com.easyinc.currentweather.mobile_ui.home.cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyinc.currentweather.R
import com.easyinc.currentweather.common.Logger
import com.easyinc.currentweather.common.base.BaseFragment
import com.easyinc.currentweather.mobile_ui.MainActivity
import com.easyinc.currentweather.mobile_ui.home.adapter.DailyWeatherAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_moscow.*
import javax.inject.Inject

class MoscowFragment : BaseFragment() {

    @Inject
    lateinit var moscowAdapter: DailyWeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = (activity as MainActivity).mainViewModel

    }

    override fun onResume() {
        mViewModel.getWeatherByCity(MOSCOW_LATLNG, MOSCOW_CODE)
        mainActivity.hideProgressBar(false)
        super.onResume()
    }

    override fun layoutId(): Int {
        return R.layout.fragment_moscow
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()

        observeWeatherData()

    }

    private fun initRecycler(){
        moscow_recycler.adapter = moscowAdapter
        moscow_recycler.layoutManager = LinearLayoutManager(context)
        moscow_recycler.setHasFixedSize(true)
    }

    private fun observeWeatherData(){
        mViewModel.observeWeather().observe(viewLifecycleOwner, Observer {
            moscowAdapter.submitList(it.daily.data)
            mainActivity.hideProgressBar(true)
        })
    }

}