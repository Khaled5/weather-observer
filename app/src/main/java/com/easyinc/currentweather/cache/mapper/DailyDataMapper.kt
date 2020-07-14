package com.easyinc.currentweather.cache.mapper

import com.easyinc.currentweather.cache.model.DailyDataCache
import com.easyinc.currentweather.data.model.DailyDataEntity
import javax.inject.Inject

class DailyDataMapper @Inject constructor(): CacheMapper<DailyDataCache,DailyDataEntity> {
    override fun mapFromCache(cache: DailyDataCache): DailyDataEntity {
        return DailyDataEntity(
            cache.daily_item_icon,
            cache.daily_item_summary,
            cache.daily_item_temperatureMax,
            cache.daily_item_temperatureMin,
            cache.daily_item_time
        )
    }

    override fun mapToCache(entity: DailyDataEntity): DailyDataCache {
        return DailyDataCache(
            entity.icon,
            entity.summary,
            entity.temperatureMax,
            entity.temperatureMin,
            entity.time
        )
    }

}