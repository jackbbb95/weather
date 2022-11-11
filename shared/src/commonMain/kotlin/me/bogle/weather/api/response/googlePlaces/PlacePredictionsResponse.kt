package me.bogle.weather.api.response.googlePlaces


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlacesAutocompletePredictionsResponse(
    @SerialName("predictions")
    val predictions: List<Prediction>? = null
)

@Serializable
data class Prediction(
    @SerialName("description")
    val description: String? = null,
    @SerialName("place_id")
    val placeId: String? = null
)

