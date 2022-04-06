package me.bogle.weather.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Minutely(
    @SerialName("dt")
    val dt: Int? = null,
    @SerialName("precipitation")
    val precipitation: Int? = null
)