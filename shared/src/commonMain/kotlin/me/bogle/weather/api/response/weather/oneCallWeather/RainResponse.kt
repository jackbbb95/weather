package me.bogle.weather.api.response.weather.oneCallWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RainResponse(
    @SerialName("1h")
    val h: Double? = null
)