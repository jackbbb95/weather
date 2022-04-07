package me.bogle.weather.android.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import me.bogle.weather.android.viewmodel.HomeViewModel
import me.bogle.weather.model.oneCallWeather.OneCallWeather

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(Unit) { viewModel.getWeather() }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.isLoading),
        onRefresh = { viewModel.getWeather() }
    ) {
        state.data?.let { WeatherContent(it) }
    }
}

@Composable
private fun WeatherContent(data: OneCallWeather) {
    LazyColumn {
        item {
            Text(text = data.toString())
        }
    }
}