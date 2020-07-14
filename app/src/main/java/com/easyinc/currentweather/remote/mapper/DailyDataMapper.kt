package com.easyinc.currentweather.remote.mapper

import com.easyinc.currentweather.data.model.DailyDataEntity
import com.easyinc.currentweather.remote.model.DailyDataModel
import javax.inject.Inject

class DailyDataMapper @Inject constructor(): ModelMapper<DailyDataModel,DailyDataEntity> {
    override fun mapFromModel(model: DailyDataModel): DailyDataEntity {
        return DailyDataEntity(
            model.icon,
            model.summary,
            model.temperatureMax,
            model.temperatureMin,
            model.time
        )
    }
}