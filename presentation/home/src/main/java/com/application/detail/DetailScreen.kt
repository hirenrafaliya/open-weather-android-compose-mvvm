package com.application.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController) {

    val context = LocalContext.current

    val viewModel: DetailViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    DetailScreenUi()
}

@Composable
private fun DetailScreenUi() {

}