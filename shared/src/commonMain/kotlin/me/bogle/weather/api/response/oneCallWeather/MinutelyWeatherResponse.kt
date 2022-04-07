package me.bogle.weather.api.response.oneCallWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MinutelyWeatherResponse(
    @SerialName("dt")
    val dt: Long,
    @SerialName("precipitation")
    val precipitation: Double? = null
)