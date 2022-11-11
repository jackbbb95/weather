package me.bogle.weather.api.response.weather.oneCallWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TempResponse(
    @SerialName("day")
    val day: Double? = null,
    @SerialName("eve")
    val eve: Double? = null,
    @SerialName("max")
    val max: Double? = null,
    @SerialName("min")
    val min: Double? = null,
    @SerialName("morn")
    val morn: Double? = null,
    @SerialName("night")
    val night: Double? = null
)