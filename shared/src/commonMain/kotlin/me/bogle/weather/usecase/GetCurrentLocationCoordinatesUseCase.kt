package me.bogle.weather.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.bogle.weather.model.Coordinates

class GetCurrentLocationCoordinatesUseCase {

    operator fun invoke(): Flow<Coordinates> =
        flow {
            // TODO Get actual coordinates from the platform
            emit(Coordinates(latitude = 41.932508392751586, longitude = -71.31313448416185))
        }
}