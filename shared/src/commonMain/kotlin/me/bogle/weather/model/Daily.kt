package me.bogle.weather.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("clouds")
    val clouds: Int? = null,
    @SerialName("dew_point")
    val dewPoint: Double? = null,
    @SerialName("dt")
    val dt: Int? = null,
    @SerialName("feels_like")
    val feelsLike: FeelsLike? = null,
    @SerialName("humidity")
    val humidity: Int? = null,
    @SerialName("moon_phase")
    val moonPhase: Double? = null,
    @SerialName("moonrise")
    val moonrise: Int? = null,
    @SerialName("moonset")
    val moonset: Int? = null,
    @SerialName("pop")
    val pop: Double? = null,
    @SerialName("pressure")
    val pressure: Int? = null,
    @SerialName("rain")
    val rain: Double? = null,
    @SerialName("sunrise")
    val sunrise: Int? = null,
    @SerialName("sunset")
    val sunset: Int? = null,
    @SerialName("temp")
    val temp: Temp? = null,
    @SerialName("uvi")
    val uvi: Double? = null,
    @SerialName("weather")
    val weather: List<Weather>? = null,
    @SerialName("wind_deg")
    val windDeg: Int? = null,
    @SerialName("wind_gust")
    val windGust: Double? = null,
    @SerialName("wind_speed")
    val windSpeed: Double? = null
) {

    @Serializable
    data class FeelsLike(
        @SerialName("day")
        val day: Double? = null,
        @SerialName("eve")
        val eve: Double? = null,
        @SerialName("morn")
        val morn: Double? = null,
        @SerialName("night")
        val night: Double? = null
    )
}