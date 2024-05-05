package com.application.search

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.application.base.common.OnStart
import com.application.base.common.SpacerM
import com.application.base.common.SpacerMax
import com.application.base.common.SpacerXS
import com.application.base.common.SpacerXXXS
import com.application.base.common.StatusBarForegroundColor
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.domain.model.SearchResult
import com.application.home.R
import com.application.home.component.SearchBar
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
        }
    )
}

@Composable
private fun SearchScreenUi(
    search: String,
    onSearchTextChange: (String) -> Unit,
    locationTitle: String,
    displayDate: String,
    searchResults: List<SearchResult>,
    onSearch: () -> Unit
) {
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
                .padding(horizontal = Paddings.xSmall)
                .animateContentSize()
        ) {
            SpacerXS()
            CurrentCityView(title = locationTitle, date = displayDate)
            SpacerXS()
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                hint = "Enter your city name",
                text = search,
                onTextChange = onSearchTextChange,
                onIme = onSearch
            )
            SpacerXS()
            SearchResultView(results = searchResults)
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
fun SearchResultView(results: List<SearchResult>) {
    LazyColumn {
        items(results, key = { it.id }) {
            SearchResultItem(it, onClick = {})
        }
    }
}

@Composable
fun SearchResultItem(result: SearchResult, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .background(MyColor.bgTertiaryMuted, MyShape.round)
            .border(0.85.dp, MyColor.bgPrimary.copy(0.10f), MyShape.round)
            .clip(MyShape.round)
            .clickable { onClick() }
            .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = "${result.name}, ${result.country}, ${result.region}",
            style = MyTypography.SB14,
            color = MyColor.bgPrimary
        )
        SpacerXS()
        SpacerMax()
        Icon(
            modifier = Modifier.size(24.dp),
            tint = MyColor.bgPrimary,
            painter = painterResource(id = R.drawable.ic_pin),
            contentDescription = ""
        )
    }
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