package me.bogle.weather.mapper

import me.bogle.weather.api.response.googlePlaces.PlaceDetailsResponse
import me.bogle.weather.model.Coordinates
import me.bogle.weather.model.googlePlaces.PlaceDetails

class GooglePlaceDetailsMapper : Mapper<PlaceDetailsResponse, PlaceDetails?> {

    override suspend fun map(model: PlaceDetailsResponse): PlaceDetails? =
        model.result?.geometry?.location?.let {
            if (it.lat != null && it.lng != null) {
                PlaceDetails(coordinates = Coordinates(latitude = it.lat, longitude = it.lng))
            } else {
                null
            }
        }
}