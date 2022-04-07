package me.bogle.weather.model.oneCallWeather

import kotlinx.datetime.LocalDateTime

data class Minutely(
    val dateTime: LocalDateTime,
    val precipitation: Double? = null
)
