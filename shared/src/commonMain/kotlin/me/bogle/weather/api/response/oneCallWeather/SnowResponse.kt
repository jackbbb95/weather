package me.bogle.weather.api.response.oneCallWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SnowResponse {
    @SerialName("1h")
    val h: Double? = null
}