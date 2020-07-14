package com.easyinc.currentweather.cache.mapper

interface CacheMapper<C, E> {

    fun mapFromCache(cache: C): E

    fun mapToCache(entity: E): C

}