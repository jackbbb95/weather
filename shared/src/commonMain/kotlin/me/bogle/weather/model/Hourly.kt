package me.bogle.weather.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    @SerialName("clouds")
    val clouds: Int? = null,
    @SerialName("dew_point")
    val dewPoint: Double? = null,
    @SerialName("dt")
    val dt: Int? = null,
    @SerialName("feels_like")
    val feelsLike: Double? = null,
    @SerialName("humidity")
    val humidity: Int? = null,
    @SerialName("pop")
    val pop: Double? = null,
    @SerialName("pressure")
    val pressure: Int? = null,
    @SerialName("rain")
    val rain: Rain? = null,
    @SerialName("temp")
    val temp: Double? = null,
    @SerialName("uvi")
    val uvi: Double? = null,
    @SerialName("visibility")
    val visibility: Int? = null,
    @SerialName("weather")
    val weather: List<Weather>? = null,
    @SerialName("wind_deg")
    val windDeg: Int? = null,
    @SerialName("wind_gust")
    val windGust: Double? = null,
    @SerialName("wind_speed")
    val windSpeed: Double? = null
)