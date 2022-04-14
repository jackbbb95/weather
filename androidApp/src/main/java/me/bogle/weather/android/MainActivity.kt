package me.bogle.weather.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import me.bogle.weather.android.screen.HomeScreen
import me.bogle.weather.android.screen.NavScreen
import me.bogle.weather.android.screen.SettingsScreen
import me.bogle.weather.android.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(typography = Typography(defaultFontFamily = FontFamily.Default)) {
                MainView()
            }
        }
    }

    @Composable
    private fun MainView() {
        val navController = rememberNavController()
        val homeViewModel by viewModel<HomeViewModel>()

        Scaffold(
            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    NAV_SCREENS.forEach { navScreen ->
                        BottomNavigationItem(
                            icon = { Icon(navScreen.icon, contentDescription = null) },
                            label = { Text(navScreen.text) },
                            selected = currentDestination?.hierarchy?.any { it.route == navScreen.route } == true,
                            onClick = {
                                navController.navigate(navScreen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }

                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HOME_NAV_SCREEN.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(HOME_NAV_SCREEN.route) { HomeScreen(homeViewModel) }
                composable(SETTINGS_NAV_SCREEN.route) { SettingsScreen() }
            }
        }
    }

    companion object {

        val HOME_NAV_SCREEN = NavScreen(route = "home", text = "Home", icon = Icons.Filled.Home)
        val SETTINGS_NAV_SCREEN =
            NavScreen(route = "settings", text = "Settings", icon = Icons.Filled.Settings)

        val NAV_SCREENS = listOf(HOME_NAV_SCREEN, SETTINGS_NAV_SCREEN)
    }
}
