package me.bogle.weather.usecase

import kotlinx.coroutines.flow.Flow
import me.bogle.weather.model.Coordinates
import me.bogle.weather.model.oneCallWeather.OneCallWeather
import me.bogle.weather.repository.WeatherRepository

class GetCurrentLocationOneCallWeatherUseCase(private val weatherRepository: WeatherRepository) {

    operator fun invoke(): Flow<OneCallWeather> {
        // TODO Get the current location from the platform
        val coordinates = Coordinates(latitude = 41.93244465716667, longitude = 71.31315381766628)

        return weatherRepository.getOneCallWeather(coordinates.latitude, coordinates.longitude)
    }
}