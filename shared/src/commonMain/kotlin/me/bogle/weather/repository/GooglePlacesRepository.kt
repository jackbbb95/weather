package me.bogle.weather.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.bogle.weather.api.GooglePlacesApi
import me.bogle.weather.mapper.GooglePlaceDetailsMapper
import me.bogle.weather.mapper.GooglePlacePredictionMapper
import me.bogle.weather.model.googlePlaces.PlaceDetails
import me.bogle.weather.model.googlePlaces.PlacePrediction
import org.koin.core.component.KoinComponent

class GooglePlacesRepository(
    private val googlePlacesApi: GooglePlacesApi,
    private val googlePlacePredictionMapper: GooglePlacePredictionMapper,
    private val googlePlaceDetailsMapper: GooglePlaceDetailsMapper
) : KoinComponent {

    fun getPlacesAutocompleteSuggestions(
        input: String,
        types: List<String> = listOf("(cities)")
    ): Flow<List<PlacePrediction>> = flow {
        val response = googlePlacesApi.getPlacesAutocompletePredictions(input, types)

        emit(googlePlacePredictionMapper.map(response))
    }

    suspend fun getPlaceDetails(placeId: String): Flow<PlaceDetails> = flow {
        val response = googlePlacesApi.getPlaceDetails(placeId)

        googlePlaceDetailsMapper.map(response)?.let {
            emit(it)
        }
    }
}