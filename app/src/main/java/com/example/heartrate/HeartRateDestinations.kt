package com.example.heartrate

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.heartrate.ui.screens.LoadingScreen

object MainDestinations {
    const val LOADING_ROUTE = "loading"
}

interface HeartRateDestination{
    val route: String
    val screen: @Composable (navController: NavController) -> Unit
}

object Loading: HeartRateDestination {
    override val route: String = MainDestinations.LOADING_ROUTE
    override val screen: @Composable (navController: NavController) -> Unit  = { LoadingScreen() }
}