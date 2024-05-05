package com.application.base.navigation

sealed class Screen(val route: String) {
    data object SplashScreen: Screen("splash_screen")
    data object HomeScreen: Screen("home_screen")
    data object SearchScreen: Screen("home_screen")

    data object InitialRoute: Screen("initial_route")
    data object RootRoute: Screen("root_route")
}