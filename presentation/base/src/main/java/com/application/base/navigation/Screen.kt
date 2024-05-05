package com.application.base.navigation

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splash_screen")

    data object DetailScreen : Screen("detail_screen/{location_url}") {
        fun withLocationUrl(locationUrl: String) = "detail_screen/${locationUrl}"
    }

    data object SearchScreen : Screen("search_screen")

    data object InitialRoute : Screen("initial_route")
    data object RootRoute : Screen("root_route")
}