package me.bogle.weather.api.response.weather.oneCallWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OneCallWeatherResponse(
    @SerialName("current")
    val current: CurrentWeatherResponse,
    @SerialName("daily")
    val daily: List<DailyWeatherResponse>,
    @SerialName("hourly")
    val hourly: List<HourlyWeatherResponse>,
    @SerialName("minutely")
    val minutely: List<MinutelyWeatherResponse>,
    @SerialName("lat")
    val lat: Double? = null,
    @SerialName("lon")
    val lon: Double? = null,
    @SerialName("timezone")
    val timezone: String? = null,
    @SerialName("timezone_offset")
    val timezoneOffset: Int? = null
)