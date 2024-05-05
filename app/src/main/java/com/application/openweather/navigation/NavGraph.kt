package com.application.openweather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.application.base.navigation.Screen
import com.application.detail.DetailScreen
import com.application.search.SearchScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.SearchScreen.route,
        route = Screen.RootRoute.route
    ) {
        composable(Screen.DetailScreen.route) {
            DetailScreen(navController = navController)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
    }
}