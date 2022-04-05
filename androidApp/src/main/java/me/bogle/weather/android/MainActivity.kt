package me.bogle.weather.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.bogle.weather.android.screen.HomeScreen
import me.bogle.weather.android.screen.SettingsScreen
import me.bogle.weather.android.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView()
        }
    }

    @Composable
    private fun MainView() {
        val navController = rememberNavController()
        val homeViewModel by viewModel<HomeViewModel>()

        Column {
            NavHost(navController = navController, startDestination = NAV_HOME) {
                composable(NAV_HOME) { HomeScreen(homeViewModel) }
                composable(NAV_SETTINGS) { SettingsScreen() }
            }
            
            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = { navController.navigate(NAV_HOME) }) {
                Text(text = "Home")
            }

            TextButton(onClick = { navController.navigate(NAV_SETTINGS) }) {
                Text(text = "Settings")
            }
        }
    }

    companion object {
        const val NAV_HOME = "home"
        const val NAV_SETTINGS = "settings"
    }
}
