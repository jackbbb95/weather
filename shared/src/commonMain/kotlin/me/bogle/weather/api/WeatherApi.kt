package me.bogle.weather.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import me.bogle.weather.model.OneCall
import me.bogle.weather.shared.BuildKonfig
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherApi : KoinComponent {

    private val httpClient: HttpClient by inject()

    suspend fun getOneCallWeather(
        latitude: Double,
        longitude: Double,
        excluding: List<String>
    ): OneCall {
        val url = if (excluding.isEmpty()) {
            "https://api.openweathermap.org/data/2.5/onecall?lat=$latitude&lon=$longitude&appid=${BuildKonfig.OPEN_WEATHER_MAP_API_KEY}"
        } else {
            "https://api.openweathermap.org/data/2.5/onecall?lat=$latitude&lon=$longitude&exclude=${excluding.joinToString()}&appid=${BuildKonfig.OPEN_WEATHER_MAP_API_KEY}"
        }

        return httpClient.get(url) {
            headers {
                append(HttpHeaders.ContentType, "application/json")
            }
        }
    }
}