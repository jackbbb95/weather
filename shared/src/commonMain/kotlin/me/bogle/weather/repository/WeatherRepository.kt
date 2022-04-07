package me.bogle.weather.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.bogle.weather.api.WeatherApi
import me.bogle.weather.mapper.OneCallWeatherMapper
import me.bogle.weather.model.TemperatureUnitType
import me.bogle.weather.model.oneCallWeather.OneCallWeather
import org.koin.core.component.KoinComponent

class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val oneCallWeatherMapper: OneCallWeatherMapper
) : KoinComponent {

    fun getOneCallWeather(
        latitude: Double,
        longitude: Double,
        units: TemperatureUnitType = TemperatureUnitType.FAHRENHEIT,
        excluding: List<String> = emptyList()
    ): Flow<OneCallWeather> = flow {
        val response = weatherApi.getOneCallWeather(
            latitude = latitude,
            longitude = longitude,
            units = units,
            excluding = excluding
        )

        emit(oneCallWeatherMapper.map(response))
    }
}