package com.application.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.application.base.common.SpacerM
import com.application.base.common.SpacerXS
import com.application.base.common.SpacerXXXS
import com.application.base.common.StatusBarForegroundColor
import com.application.base.theme.MyColor
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.home.component.SearchBar

@Composable
fun SearchScreen(navController: NavHostController) {

    val context = LocalContext.current

    val viewModel: SearchViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    SearchScreenUi(search = uiState.search, onSearchTextChange = { viewModel.changeSearchText(it) })
}

@Composable
private fun SearchScreenUi(search: String, onSearchTextChange: (String) -> Unit) {
    StatusBarForegroundColor(isLight = true)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MyColor.accentPrimary)
                .statusBarsPadding()
        ) {
            SpacerXS()
            CurrentCityView(title = "Surat, Gujarat", date = "Monday, 07 March")
            SpacerXS()
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Paddings.xSmall),
                hint = "Enter your city name",
                text = search,
                onTextChange = onSearchTextChange,
            )
            SpacerM()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {

        }
    }
}

@Composable
fun CurrentCityView(title: String, date: String) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, style = MyTypography.B20, color = MyColor.bgPrimary)
        SpacerXXXS()
        Text(text = date, style = MyTypography.N14, color = MyColor.bgSecondary)
    }
}