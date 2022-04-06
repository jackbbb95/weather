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
import me.bogle.weather.repository.WeatherRepository

class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun getWeather() {
        // TODO Create Usecase
        weatherRepository.getOneCallWeather(41.93244465716667, -71.31315381766628)
            .flowOn(Dispatchers.IO)
            .onEach { state = HomeState(currentText = it) }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }
}


data class HomeState(val currentText: String = "N/A")