package me.bogle.weather.model.oneCallWeather

import kotlinx.datetime.LocalDateTime

data class Daily(
    val dateTime: LocalDateTime,
    val clouds: Int? = null,
    val dewPoint: Double? = null,
    val feelsLike: FeelsLike? = null,
    val humidity: Int? = null,
    val moonPhase: Double? = null,
    val moonrise: Int? = null,
    val moonset: Int? = null,
    val pop: Double? = null,
    val pressure: Int? = null,
    val rain: Double? = null,
    val snow: Double? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
    val temp: Temperatures? = null,
    val uvi: Double? = null,
    val weather: List<WeatherType>? = null,
    val windDeg: Int? = null,
    val windGust: Double? = null,
    val windSpeed: Double? = null
) {

    data class Temperatures(
        val day: Double? = null,
        val eve: Double? = null,
        val max: Double? = null,
        val min: Double? = null,
        val morn: Double? = null,
        val night: Double? = null
    )

    data class FeelsLike(
        val day: Double? = null,
        val eve: Double? = null,
        val morn: Double? = null,
        val night: Double? = null
    )
}