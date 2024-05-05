package com.application.home

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.application.base.common.OnStart
import com.google.android.gms.location.LocationServices

@Composable
fun HomeScreen(navController: NavHostController) {

    val context = LocalContext.current

    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    OnStart {
        getCurrentLocation(context = context, onLocation = {

        })
    }

    HomeScreenUi()
}

@Composable
private fun HomeScreenUi() {

}

@SuppressLint("MissingPermission")
private fun getCurrentLocation(context: Context, onLocation: (Location) -> Unit) {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        location.also {
            onLocation(it)
        }
    }
}