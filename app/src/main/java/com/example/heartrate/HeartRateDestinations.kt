package com.example.heartrate

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.heartrate.ui.screens.HomepageScreen
import com.example.heartrate.ui.screens.LoadingScreen
import com.example.heartrate.ui.screens.OnboardingScreen

object MainDestinations {
    const val LOADING_ROUTE = "loading"
    const val ONBOARDING_ROUTE = "onboarding"
    const val HOMEPAGE_ROUTE = "homepage"
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

object Onboarding: HeartRateDestination {
    override val route: String = MainDestinations.ONBOARDING_ROUTE
    override val screen: @Composable (navController: NavController) -> Unit  = { navController ->
        OnboardingScreen(navController = navController) }
}

object Homepage: HeartRateDestination {
    override val route: String = MainDestinations.HOMEPAGE_ROUTE
    override val screen: @Composable (navController: NavController) -> Unit  = { HomepageScreen() }
}