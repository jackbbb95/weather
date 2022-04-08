package me.bogle.weather.usecase

import kotlinx.coroutines.flow.Flow
import me.bogle.weather.model.Coordinates
import me.bogle.weather.model.oneCallWeather.OneCallWeather
import me.bogle.weather.repository.WeatherRepository

class GetCurrentLocationOneCallWeatherUseCase(private val weatherRepository: WeatherRepository) {

    operator fun invoke(): Flow<OneCallWeather> {
        // TODO Get the current location from the platform
        val coordinates = Coordinates(latitude = 41.932508392751586, longitude = -71.31313448416185)
        return weatherRepository.getOneCallWeather(coordinates.latitude, coordinates.longitude)
    }
}