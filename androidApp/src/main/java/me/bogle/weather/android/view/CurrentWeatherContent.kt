package me.bogle.weather.android.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.bogle.weather.model.oneCallWeather.Current

@Composable
fun CurrentWeatherContent(data: Current) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            TemperatureHeader(data = data)
        }
    }
}

@Composable
private fun TemperatureHeader(data: Current) {
    Column {
        data.temp?.let {
            Text(
                text = "$it",
                fontSize = 96.sp
            )
        }

        data.feelsLike?.let {
            Text(
                text = "Feels like ${it}º",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}