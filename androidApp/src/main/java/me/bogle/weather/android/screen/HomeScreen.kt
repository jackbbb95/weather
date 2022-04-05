package me.bogle.weather.android.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import me.bogle.weather.android.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    Column {
        Text(text = "Home Screen!")
        Text(text = viewModel.state.currentText)
        Button(onClick = { viewModel.getWeather() }) {
            Text("Testing!")
        }
    }
}