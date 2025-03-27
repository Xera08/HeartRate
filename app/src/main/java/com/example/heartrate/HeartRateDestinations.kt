package com.example.heartrate

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.heartrate.ui.screens.LoadingScreen
import com.example.heartrate.ui.screens.Onboarding1Screen

object MainDestinations {
    const val LOADING_ROUTE = "loading"
    const val ONBOARDING1_ROUTE = "onboarding1"

}

interface HeartRateDestination{
    val route: String
    val screen: @Composable (navController: NavController) -> Unit
}

object Loading: HeartRateDestination {
    override val route: String = MainDestinations.LOADING_ROUTE
    override val screen: @Composable (navController: NavController) -> Unit  = { navController ->
        LoadingScreen(navController = navController) }
}

object Onboarding1: HeartRateDestination {
    override val route: String = MainDestinations.LOADING_ROUTE
    override val screen: @Composable (navController: NavController) -> Unit  = { navController ->
        Onboarding1Screen(navController = navController) }
}