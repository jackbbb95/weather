package me.bogle.weather.api

import io.ktor.client.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherApi : KoinComponent {

    private val httpClient: HttpClient by inject()

    fun getWeather() = "Test Complete: $httpClient"
}