package com.easyinc.currentweather.mobile_ui.map

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.easyinc.currentweather.R
import com.easyinc.currentweather.common.base.BaseFragment
import com.easyinc.currentweather.common.extentions.bitmapDescriptorFromVector
import com.easyinc.currentweather.mobile_ui.MainActivity
import com.easyinc.currentweather.mobile_ui.utils.TemperatureIcon
import com.easyinc.currentweather.presentation.model.CurrentlyWeatherView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.choosed_city_weather_raw.*
import kotlinx.android.synthetic.main.fragment_map.*

const val REQ_CODE = 9

class MapFragment : BaseFragment(), OnMapReadyCallback{

    private var mMap: GoogleMap? = null

    private var secondaryMarker: Marker? = null
    private val secondaryMarkerList = ArrayList<Marker>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = (activity as MainActivity).mainViewModel

    }

    override fun layoutId(): Int {
        return R.layout.fragment_map
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()

        observeUserLocation()

        observeCurrentLocation()

        initOnClick()

    }

    private fun initMap(){
        val fragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        fragment?.getMapAsync(this)
    }

    private fun drawCurrentTempWindow(currentlyWeatherView: CurrentlyWeatherView){
        main_icon.setImageResource(TemperatureIcon.getIcon(currentlyWeatherView.icon))
        main_temp.text = (currentlyWeatherView.temperature.minus(32) / 1.8).toInt().toString().plus(resources.getString(R.string.celsius))
        main_state.text = currentlyWeatherView.summary
    }

    private fun hideMapTempWindow(hide: Boolean){
        current_temp_window.visibility = if (hide) View.GONE else View.VISIBLE
    }

    private fun hideMapProgressBar(hide: Boolean){
        map_current_temp_progress.visibility = if (hide) View.GONE else View.VISIBLE
    }

    private fun initOnClick(){
        hide_map_temp_window.setOnClickListener {
            hideMapTempWindow(true)
            removeSecondaryMarker()
        }

        current_location.setOnClickListener {
            mViewModel.getUserLocation()
            hideMapTempWindow(false)
            hideMapProgressBar(false)
        }
    }

    private fun onMapClicked(){
            mMap?.setOnMapClickListener {
                moveCameraToClickedLocation(it)
                mViewModel.getMapCurrentWeather(it)
                hideMapProgressBar(false)
                hideMapTempWindow(false)
            }
    }

    private fun getUserLocation(){
        if (hasFineLocation() && hasCoarseLocation()){
            mViewModel.getUserLocation()
            hideMapProgressBar(false)
        }else{
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION)
                , REQ_CODE
            )
        }
    }

    private fun observeCurrentLocation(){
        mViewModel.observeMapCurrentWeather().observe(viewLifecycleOwner, Observer {
            drawCurrentTempWindow(it)
            hideMapProgressBar(true)
        })
    }

    private fun observeUserLocation(){
        mViewModel.observeUserLocation().observe(viewLifecycleOwner, Observer {
            if (!it.latitude.equals(0.0)) {
                moveCameraToUserLocation(it)
                mViewModel.getMapCurrentWeather(it)
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        getUserLocation()
        hideMapProgressBar(false)

        onMapClicked()
    }

    private fun moveCameraToUserLocation(latLang: LatLng, zoom: Float = 5f){
        val markerOptions = MarkerOptions().position(latLang)
        markerOptions.icon(requireContext().bitmapDescriptorFromVector(R.drawable.icon_location))
        mMap?.addMarker(markerOptions)?.showInfoWindow()
        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latLang.latitude,latLang.longitude), zoom))
    }

    private fun moveCameraToClickedLocation(latLang: LatLng, zoom: Float = 5f){
        removeSecondaryMarker()
        val markerOptions = MarkerOptions().position(latLang)
        secondaryMarker = mMap?.addMarker(markerOptions)
        secondaryMarker?.let { secondaryMarkerList.add(it) }
        secondaryMarker?.showInfoWindow()
        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latLang.latitude,latLang.longitude), zoom))
    }

    private fun removeSecondaryMarker(){
        if (secondaryMarkerList.size > 0){
            secondaryMarkerList.remove(secondaryMarker)
            secondaryMarker?.remove()
        }
    }

    private fun hasFineLocation() =
        ContextCompat.checkSelfPermission(requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun hasCoarseLocation() =
        ContextCompat.checkSelfPermission(requireContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQ_CODE){
            mViewModel.getUserLocation()
            hideMapProgressBar(false)
        }
    }

}