package me.bogle.weather.android.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import me.bogle.weather.usecase.GetCurrentLocationOneCallWeatherUseCase

class HomeViewModel(
    private val getCurrentLocationOneCallWeather: GetCurrentLocationOneCallWeatherUseCase
) : ViewModel() {

    var state by mutableStateOf<HomeState>(HomeState.Initial)
        private set

    fun getWeather() {
        getCurrentLocationOneCallWeather()
            .flowOn(Dispatchers.IO)
            .onStart { state = HomeState.Loading }
            .onEach { state = HomeState.DisplayingWeather(currentText = it.toString()) }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }
}


sealed class HomeState {

    object Initial : HomeState()

    object Loading : HomeState()

    data class DisplayingWeather(val currentText: String) : HomeState()
}