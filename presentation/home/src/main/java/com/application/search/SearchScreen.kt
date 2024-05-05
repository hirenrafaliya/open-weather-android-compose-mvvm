package com.application.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.application.base.common.SpacerL
import com.application.base.common.StatusBarForegroundColor
import com.application.base.theme.MyColor

@Composable
fun SearchScreen(navController: NavHostController) {

    val context = LocalContext.current

    val viewModel: SearchViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    SearchScreenUi()
}

@Composable
private fun SearchScreenUi() {
    StatusBarForegroundColor(isLight = true)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MyColor.accentPrimary)
                .statusBarsPadding()
        ) {
            SpacerL()
            SpacerL()
            SpacerL()
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .weight(1f)) {

        }
    }
}