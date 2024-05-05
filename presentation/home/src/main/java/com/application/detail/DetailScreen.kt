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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
        tomorrowDay = uiState.forecast?.forecastDays?.first(),
        nextDays = uiState.forecast?.forecastDays?.subList(
            2,
            uiState.forecast?.forecastDays?.lastIndex ?: 0
        )
    )
}

@Composable
private fun DetailScreenUi(
    locationTitle: String,
    displayDate: String,
    onBack: () -> Unit,
    currentDay: LocationWeather?,
    tomorrowDay: Forecast.ForecastDay?,
    nextDays: List<Forecast.ForecastDay>?
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
                .verticalScroll(rememberScrollState())
        ) {

            SpacerL()
            TomorrowView(day = tomorrowDay)
            SpacerL()
            NextDaysView(days = nextDays ?: listOf())
            SpacerL()
            SpacerL()
        }
    }
}

@Composable
fun NextDaysView(days: List<Forecast.ForecastDay>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "UPCOMING DAYS", style = MyTypography.B14, color = MyColor.textSecondary)
        SpacerXXS()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    spotColor = MyColor.accentPrimary.copy(0.65f),
                    shape = MyShape.small
                )
                .background(MyColor.bgPrimary, MyShape.small)
                .border(0.8.dp, MyColor.textTertiaryMuted.copy(0.25f), MyShape.small)
                .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall)
        ) {
            days.forEachIndexed { index, forecastDay ->
                NextDayItem(day = forecastDay, showDivider = index != days.lastIndex)
            }
        }
    }
}

@Composable
private fun NextDayItem(day: Forecast.ForecastDay, showDivider: Boolean = true) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f), contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = day.conditionalUrl,
                contentDescription = "",
                modifier = Modifier
                    .size(44.dp),
                contentScale = ContentScale.Crop
            )
        }
        SpacerXS()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f),
            text = day.getDisplayDate(),
            style = MyTypography.SB16,
            color = MyColor.textPrimary
        )
        SpacerXS()
        Spacer(
            modifier = Modifier
                .height(22.dp)
                .width(1.dp)
                .background(MyColor.textTertiaryMuted.copy(0.25f))
        )
        SpacerXS()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.35f),
            text = "${day.minTempC.toInt()}° - ${day.maxTempC.toInt()}°",
            style = MyTypography.B16,
            color = MyColor.textTertiary,
            textAlign = TextAlign.End
        )
        SpacerXS()
    }
    if (showDivider)
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MyColor.textTertiaryMuted.copy(0.25f))
        )
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