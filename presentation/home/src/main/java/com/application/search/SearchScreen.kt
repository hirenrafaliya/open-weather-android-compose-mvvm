package com.application.search

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.application.base.common.OnStart
import com.application.base.common.SpacerM
import com.application.base.common.SpacerXS
import com.application.base.common.SpacerXXXS
import com.application.base.common.StatusBarForegroundColor
import com.application.base.navigation.Screen
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.domain.model.Location
import com.application.domain.model.LocationWeather
import com.application.search.component.PinnedLocationList
import com.application.search.component.SearchBar
import com.application.search.component.SearchResultView
import com.google.android.gms.location.LocationServices

@Composable
fun SearchScreen(navController: NavHostController) {

    val context = LocalContext.current

    val viewModel: SearchViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    OnStart {
        getCurrentLocation(context = context, onLocation = {
            viewModel.getCurrentCity(it)
        })
    }

    SearchScreenUi(
        search = uiState.search,
        onSearchTextChange = { viewModel.changeSearchText(it) },
        locationTitle = uiState.getLocationTitle(),
        displayDate = uiState.getDisplayDate(),
        searchResults = uiState.searchResults,
        onSearch = {
            viewModel.search()
        },
        onClose = {
            viewModel.clearSearch()
        },
        onPin = {
            viewModel.pinLocation(it)
        }, pinnedLocations = uiState.pinnedLocations,
        onLocationClick = {
            navController.navigate(Screen.DetailScreen.withLocationUrl(it.location.url))
        }
    )
}

@Composable
private fun SearchScreenUi(
    search: String,
    onSearchTextChange: (String) -> Unit,
    locationTitle: String,
    displayDate: String,
    searchResults: List<Location>,
    onSearch: () -> Unit,
    onClose: () -> Unit,
    onPin: (Location) -> Unit,
    pinnedLocations: List<LocationWeather>,
    onLocationClick: (LocationWeather) -> Unit
) {
    StatusBarForegroundColor(isLight = true)
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MyColor.accentPrimary)
                .statusBarsPadding()
                .padding(horizontal = Paddings.xSmall)
                .animateContentSize()
        ) {
            SpacerXS()
            CurrentCityView(title = locationTitle, date = displayDate)
            SpacerXS()
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                hint = "Enter your city name",
                text = search,
                onTextChange = onSearchTextChange,
                onIme = onSearch,
                onClose = onClose
            )
            SpacerXS()
            SearchResultView(results = searchResults, onPin = onPin)
            SpacerM()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall)
        ) {
            PinnedLocationList(locations = pinnedLocations, onClick = onLocationClick)
        }
    }
}


@SuppressLint("MissingPermission")
private fun getCurrentLocation(context: Context, onLocation: (android.location.Location) -> Unit) {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        location.also {
            onLocation(it)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CurrentCityView(title: String, date: String) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .basicMarquee(),
            text = title,
            style = MyTypography.B20,
            color = MyColor.bgPrimary,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        SpacerXXXS()
        Text(text = date, style = MyTypography.N14, color = MyColor.bgSecondary)
    }
}