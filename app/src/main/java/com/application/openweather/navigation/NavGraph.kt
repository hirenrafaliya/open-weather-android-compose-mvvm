package com.application.openweather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.application.base.navigation.navGraph
import com.application.base.navigation.Screen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.InitialRoute.route,
        route = Screen.RootRoute.route
    ) {
        navGraph(navController = navController)
    }
}