package me.bogle.weather.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OneCall(
    @SerialName("current")
    val current: Current? = null,
    @SerialName("daily")
    val daily: List<Daily>? = null,
    @SerialName("hourly")
    val hourly: List<Hourly>? = null,
    @SerialName("lat")
    val lat: Double? = null,
    @SerialName("lon")
    val lon: Double? = null,
    @SerialName("minutely")
    val minutely: List<Minutely>? = null,
    @SerialName("timezone")
    val timezone: String? = null,
    @SerialName("timezone_offset")
    val timezoneOffset: Int? = null
)