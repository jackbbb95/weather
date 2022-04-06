package me.bogle.weather.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.bogle.weather.api.WeatherApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherRepository : KoinComponent {

    private val weatherApi: WeatherApi by inject()

    fun getOneCallWeather(
        latitude: Double,
        longitude: Double,
        excluding: List<String> = emptyList()
    ): Flow<String> = flow {
        emit(
            weatherApi.getOneCallWeather(
                latitude = latitude,
                longitude = longitude,
                excluding = excluding
            ).toString() // TODO Map to better representation
        )
    }
}