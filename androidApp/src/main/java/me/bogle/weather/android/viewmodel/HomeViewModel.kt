package me.bogle.weather.android.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import me.bogle.weather.repository.WeatherRepository

class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun getWeather() {
        state = HomeState(currentText = weatherRepository.getWeather())
    }
}


data class HomeState(val currentText: String = "N/A")