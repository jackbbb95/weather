package me.bogle.weather.mapper

interface Mapper<T1, T2> {

    suspend fun map(model: T1): T2
}