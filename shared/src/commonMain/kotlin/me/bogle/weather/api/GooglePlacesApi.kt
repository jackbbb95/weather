package me.bogle.weather.api

import io.ktor.client.*
import io.ktor.client.request.*
import me.bogle.weather.api.response.googlePlaces.PlaceDetailsResponse
import me.bogle.weather.api.response.googlePlaces.PlacesAutocompletePredictionsResponse
import me.bogle.weather.shared.BuildKonfig
import org.koin.core.component.KoinComponent

class GooglePlacesApi(private val httpClient: HttpClient) : KoinComponent {

    suspend fun getPlacesAutocompletePredictions(
        input: String,
        types: List<String>
    ): PlacesAutocompletePredictionsResponse =
        httpClient.get("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=$input&types=$types&key=${BuildKonfig.GOOGLE_PLACES_API_KEY}")

    suspend fun getPlaceDetails(placeId: String): PlaceDetailsResponse =
        httpClient.get("https://maps.googleapis.com/maps/api/place/details/json?place_id=$placeId&key=${BuildKonfig.GOOGLE_PLACES_API_KEY}")
}