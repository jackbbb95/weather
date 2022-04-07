package me.bogle.weather.android.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import me.bogle.weather.android.viewmodel.HomeState
import me.bogle.weather.android.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    when (val state = viewModel.state) {
        is HomeState.Initial ->
            InitialState(getWeather = { viewModel.getWeather() })
        is HomeState.Loading ->
            LoadingState()
        is HomeState.DisplayingWeather ->
            DisplayingWeatherState(state)
    }
}

@Composable
fun InitialState(getWeather: () -> Unit) {
    Column {
        Text(text = "Home Screen!")
        Button(onClick = getWeather) {
            Text("Testing!")
        }
    }
}

@Composable
fun LoadingState() {
    Box {
        CircularProgressIndicator()
    }
}

@Composable
fun DisplayingWeatherState(state: HomeState.DisplayingWeather) {
    LazyColumn {
        item {
            Text(text = "Home Screen!")
            Text(text = state.currentText)
        }
    }
}