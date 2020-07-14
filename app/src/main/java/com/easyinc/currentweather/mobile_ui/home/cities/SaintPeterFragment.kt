package com.easyinc.currentweather.mobile_ui.home.cities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyinc.currentweather.R
import com.easyinc.currentweather.common.base.BaseFragment
import com.easyinc.currentweather.mobile_ui.MainActivity
import com.easyinc.currentweather.mobile_ui.home.adapter.DailyWeatherAdapter
import kotlinx.android.synthetic.main.fragment_saint_peter.*
import javax.inject.Inject

class SaintPeterFragment : BaseFragment() {

    @Inject
    lateinit var saintPeterAdapter: DailyWeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = (activity as MainActivity).mainViewModel

    }

    override fun layoutId(): Int {
        return R.layout.fragment_saint_peter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()

        observeWeatherData()

    }

    override fun onResume() {
        super.onResume()
        mViewModel.getWeatherByCity(SAINT_PETER_LATLNG, SAINT_PETER_CODE)
        mainActivity.hideProgressBar(false)
    }

    private fun initRecycler(){
        saint_peter_recycler.adapter = saintPeterAdapter
        saint_peter_recycler.layoutManager = LinearLayoutManager(context)
        saint_peter_recycler.setHasFixedSize(true)
    }

    private fun observeWeatherData(){
        mViewModel.observeWeather().observe(viewLifecycleOwner, Observer {
            saintPeterAdapter.submitList(it.daily.data)
            mainActivity.hideProgressBar(true)
        })
    }
}