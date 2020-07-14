package com.easyinc.currentweather.data.mapper

interface EntityMapper<E, D> {

    fun mapFrom(entity: E): D

    fun mapTo(entity: D): E

}