package com.easyinc.currentweather.mobile_ui.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyinc.currentweather.R
import com.easyinc.currentweather.common.extentions.convertToDate
import com.easyinc.currentweather.common.extentions.inflate
import com.easyinc.currentweather.mobile_ui.utils.TemperatureIcon
import com.easyinc.currentweather.presentation.model.DailyDataWeatherView
import kotlinx.android.synthetic.main.day_weather_raw.view.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class DailyWeatherAdapter @Inject constructor(): RecyclerView.Adapter<DailyWeatherAdapter.DailyViewHolder>() {

    private var daysList = listOf<DailyDataWeatherView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DailyViewHolder(parent.inflate(
        R.layout.day_weather_raw))

    override fun getItemCount() = daysList.size

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) = holder.bind(daysList[position])

    fun submitList(list: List<DailyDataWeatherView>){
        daysList = list
        notifyDataSetChanged()
    }

    inner class DailyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(dailyDataWeatherView: DailyDataWeatherView){
            val average = ((dailyDataWeatherView.temperatureMin + dailyDataWeatherView.temperatureMax) / 2)
            itemView.day_weather_temp.text = (average.minus(32) / 1.8).toInt().toString().plus("°C")
            itemView.day_weather_icon.setImageResource(TemperatureIcon.getIcon(dailyDataWeatherView.icon))
            itemView.day_weather_date.text = dailyDataWeatherView.time.toString().convertToDate()
        }
    }


}