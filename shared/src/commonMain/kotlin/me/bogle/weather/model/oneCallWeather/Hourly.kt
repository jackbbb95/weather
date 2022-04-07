package me.bogle.weather.model.oneCallWeather

import kotlinx.datetime.LocalDateTime
import me.bogle.weather.api.response.oneCallWeather.WeatherResponse

data class Hourly(
    val dateTime: LocalDateTime,
    val clouds: Int? = null,
    val dewPoint: Double? = null,
    val feelsLike: Double? = null,
    val humidity: Int? = null,
    val pop: Double? = null,
    val pressure: Int? = null,
    val rainAmount: Double? = null,
    val snowAmount: Double? = null,
    val temp: Double? = null,
    val uvi: Double? = null,
    val visibility: Int? = null,
    val weather: List<WeatherType>? = null,
    val windDeg: Int? = null,
    val windGust: Double? = null,
    val windSpeed: Double? = null
)
