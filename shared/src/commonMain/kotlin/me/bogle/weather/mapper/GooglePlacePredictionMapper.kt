package me.bogle.weather.mapper

import me.bogle.weather.api.response.googlePlaces.PlacesAutocompletePredictionsResponse
import me.bogle.weather.model.googlePlaces.PlacePrediction

class GooglePlacePredictionMapper : Mapper<PlacesAutocompletePredictionsResponse, List<PlacePrediction>> {

    override suspend fun map(model: PlacesAutocompletePredictionsResponse): List<PlacePrediction> =
        model.predictions?.let { predictions ->
            predictions.mapNotNull { prediction ->
                if (prediction.description != null && prediction.placeId != null) {
                    PlacePrediction(
                        description = prediction.description,
                        placeId = prediction.placeId
                    )
                } else null
            }
        } ?: emptyList()
}