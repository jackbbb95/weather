package me.bogle.weather.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import me.bogle.weather.model.Coordinates
import me.bogle.weather.model.oneCallWeather.OneCallWeather
import me.bogle.weather.usecase.GetCurrentLocationCoordinatesUseCase
import me.bogle.weather.usecase.GetOneCallWeatherUseCase

@OptIn(FlowPreview::class)
class HomeViewModel(
    private val getCurrentLocationCoordinates: GetCurrentLocationCoordinatesUseCase,
    private val getOneCallWeather: GetOneCallWeatherUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    fun loadInitialWeather() {
        getCurrentLocationCoordinates()
            .flatMapConcat { getWeatherForCoordinates(it) }
            .launchIn(viewModelScope)
    }

    fun refreshWeather() =
        getWeatherForCoordinates(state.value.coordinates)
            .launchIn(viewModelScope)

    private fun getWeatherForCoordinates(coordinates: Coordinates) =
        getOneCallWeather(coordinates = coordinates)
            .flowOn(Dispatchers.IO)
            .onStart { _state.value = _state.value.copy(isLoading = true) }
            .onEach { _state.value = _state.value.copy(isLoading = false, data = it) }
            .flowOn(Dispatchers.Main)
}

data class HomeState(
    val isLoading: Boolean = true,
    val coordinates: Coordinates = Coordinates(
        latitude = 40.748439489464715,
        longitude = -73.98566569212443
    ),
    val data: OneCallWeather? = null
)