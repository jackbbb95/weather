package me.bogle.weather.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import me.bogle.weather.model.oneCallWeather.OneCallWeather
import me.bogle.weather.usecase.GetCurrentLocationOneCallWeatherUseCase

class HomeViewModel(
    private val getCurrentLocationOneCallWeather: GetCurrentLocationOneCallWeatherUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(isLoading = true))
    val state: StateFlow<HomeState> = _state

    fun getWeather() =
        getCurrentLocationOneCallWeather()
            .flowOn(Dispatchers.IO)
            .onStart {
                _state.value = _state.value.copy(isLoading = true)
            }
            .onEach {
                _state.value = HomeState(isLoading = false, data = it)
            }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
}

data class HomeState(
    val isLoading: Boolean,
    val data: OneCallWeather? = null
)