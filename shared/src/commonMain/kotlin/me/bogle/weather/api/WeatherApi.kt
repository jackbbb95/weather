package me.bogle.weather.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import me.bogle.weather.api.response.weather.oneCallWeather.OneCallWeatherResponse
import me.bogle.weather.model.TemperatureUnitType
import me.bogle.weather.shared.BuildKonfig
import org.koin.core.component.KoinComponent

class WeatherApi(private val httpClient: HttpClient) : KoinComponent {

    suspend fun getOneCallWeather(
        latitude: Double,
        longitude: Double,
        units: TemperatureUnitType,
        excluding: List<String>
    ): OneCallWeatherResponse {
        val url = if (excluding.isEmpty()) {
            "https://api.openweathermap.org/data/2.5/onecall?lat=$latitude&lon=$longitude&units=${units.value}&appid=${BuildKonfig.OPEN_WEATHER_MAP_API_KEY}"
        } else {
            "https://api.openweathermap.org/data/2.5/onecall?lat=$latitude&lon=$longitude&units=${units.value}&exclude=${excluding.joinToString()}&appid=${BuildKonfig.OPEN_WEATHER_MAP_API_KEY}"
        }

        return httpClient.get(url) {
            headers {
                append(HttpHeaders.ContentType, "application/json")
            }
        }
    }
}