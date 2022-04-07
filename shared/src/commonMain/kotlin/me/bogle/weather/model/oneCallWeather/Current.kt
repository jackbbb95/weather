package me.bogle.weather.model.oneCallWeather

import kotlinx.datetime.LocalDateTime

data class Current(
    val dateTime: LocalDateTime,
    val clouds: Int? = null,
    val dewPoint: Double? = null,
    val feelsLike: Double? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,
    val rainAmount: Double? = null,
    val snowAmount: Double? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
    val temp: Double? = null,
    val uvi: Double? = null,
    val visibility: Int? = null,
    val weather: List<WeatherType>? = null,
    val windDeg: Int? = null,
    val windGust: Double? = null,
    val windSpeed: Double? = null
)