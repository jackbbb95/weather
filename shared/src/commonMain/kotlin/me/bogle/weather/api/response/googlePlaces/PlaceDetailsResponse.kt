package me.bogle.weather.api.response.googlePlaces


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaceDetailsResponse(
    @SerialName("result")
    val result: PlaceDetails? = null,
    @SerialName("status")
    val status: String? = null
)

@Serializable
data class PlaceDetails(
    @SerialName("geometry")
    val geometry: Geometry? = null
)

@Serializable
data class Geometry(
    @SerialName("location")
    val location: Location? = null
)

@Serializable
data class Location(
    @SerialName("lat")
    val lat: Double? = null,
    @SerialName("lng")
    val lng: Double? = null
)