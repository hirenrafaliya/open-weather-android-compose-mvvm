package com.application.detail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.DefaultShadowColor
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
import com.application.base.common.StatusBarForegroundColor
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
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
        currentDay = uiState.forecast?.current
    )
}

@Composable
private fun DetailScreenUi(
    locationTitle: String,
    displayDate: String,
    onBack: () -> Unit,
    currentDay: LocationWeather?
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

        }
    }
}

@Composable
fun TodayView(currentDay: LocationWeather?) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "TODAY", style = MyTypography.B14, color = MyColor.bgSecondary)
        SpacerXS()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    spotColor = DefaultShadowColor.copy(0.55f),
                    shape = MyShape.small
                )
                .background(MyColor.accentPrimary, MyShape.small)
                .background(color = MyColor.bgTertiaryMuted.copy(0.25f), shape = MyShape.small)
                .border(0.8.dp, MyColor.bgPrimary.copy(0.25f), MyShape.small)
                .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = currentDay?.tempCel.toString() + " °",
                style = MyTypography.B24.copy(fontSize = 32.sp, color = MyColor.bgPrimary),
                textAlign = TextAlign.Center
            )
            SpacerXS()
            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .height(50.dp)
                    .background(MyColor.bgTertiaryMuted.copy(0.25f))
            )
            SpacerXS()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                Text(
                    text = currentDay?.condition ?: "",
                    style = MyTypography.B16.copy(color = MyColor.bgPrimary)
                )
                Text(
                    text = "Feels like " + currentDay?.feelTemp + "°",
                    style = MyTypography.SB14.copy(color = MyColor.bgPrimary)
                )
            }
            SpacerXS()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.65f), contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = currentDay?.conditionIconUrl ?: "",
                    contentDescription = "",
                    modifier = Modifier
                        .size(44.dp),
                    contentScale = ContentScale.Crop
                )
            }
            SpacerXS()
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