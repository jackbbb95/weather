package me.bogle.weather.repository

import me.bogle.weather.api.WeatherApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherRepository : KoinComponent {

    private val weatherApi: WeatherApi by inject()

    fun getWeather() = weatherApi.getWeather()
}