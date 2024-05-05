package com.application.detail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.application.base.common.SpacerL
import com.application.base.common.SpacerM
import com.application.base.common.SpacerXS
import com.application.base.common.SpacerXXS
import com.application.base.common.StatusBarForegroundColor
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.detail.component.TodayView
import com.application.detail.component.TomorrowView
import com.application.domain.model.Forecast
import com.application.domain.model.LocationWeather
import com.application.search.CurrentCityView

@Composable
fun DetailScreen(navController: NavHostController) {

    val context = LocalContext.current

    val viewModel: DetailViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DetailScreenUi(
        locationTitle = uiState.getLocationTitle(),
        displayDate = uiState.getDisplayDate(),
        onBack = {
            navController.popBackStack()
        },
        currentDay = uiState.forecast?.current,
        tomorrowDay = uiState.forecast?.forecastDays?.first()
    )
}

@Composable
private fun DetailScreenUi(
    locationTitle: String,
    displayDate: String,
    onBack: () -> Unit,
    currentDay: LocationWeather?,
    tomorrowDay: Forecast.ForecastDay?
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
            TopAppBar(locationTitle = locationTitle, displayDate = displayDate, onBack = onBack)
            SpacerM()
            TodayView(currentDay = currentDay)
            SpacerL()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall)
        ) {

            SpacerL()
            TomorrowView(day = tomorrowDay)

        }
    }
}

@Composable
fun TopAppBar(locationTitle: String, displayDate: String, onBack: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBack) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "",
                tint = MyColor.bgPrimary
            )
        }
        SpacerXS()
        CurrentCityView(
            title = locationTitle, date = displayDate, alignment = Alignment.Start
        )
    }
}