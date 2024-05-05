package com.application.base.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.navGraph(navController: NavHostController) {
    navigation(startDestination = Screen.SplashScreen.route, route = Screen.InitialRoute.route) {
        composable(Screen.SplashScreen.route) {
//            SplashScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
//            HomeScreen(navController = navController)
        }
    }
}