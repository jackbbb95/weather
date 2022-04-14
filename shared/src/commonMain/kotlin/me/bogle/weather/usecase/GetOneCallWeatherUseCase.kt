package me.bogle.weather.usecase

import kotlinx.coroutines.flow.Flow
import me.bogle.weather.model.Coordinates
import me.bogle.weather.model.oneCallWeather.OneCallWeather
import me.bogle.weather.repository.WeatherRepository

class GetOneCallWeatherUseCase(private val weatherRepository: WeatherRepository) {

    operator fun invoke(coordinates: Coordinates): Flow<OneCallWeather> {
        return weatherRepository.getOneCallWeather(coordinates.latitude, coordinates.longitude)
    }
}