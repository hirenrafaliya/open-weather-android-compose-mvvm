package com.application.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.application.base.common.SpacerS
import com.application.base.common.SpacerXS
import com.application.base.common.SpacerXXS
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.domain.model.LocationWeather


@Composable
fun PinnedLocationList(locations: List<LocationWeather>) {
    LazyColumn(contentPadding = PaddingValues(top = Paddings.xxxSmall, bottom = 120.dp)) {
        items(locations, key = { it.location.url }) {
            PinnedLocation(
                modifier = Modifier
                    .padding(vertical = Paddings.xxxSmall)
                    .fillMaxWidth(),
                weather = it
            )
        }
    }
}

@Composable
fun PinnedLocation(modifier: Modifier = Modifier, weather: LocationWeather) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(12.dp, spotColor = MyColor.accentPrimary.copy(0.85f))
            .background(MyColor.bgPrimary, MyShape.small)
            .border(1.dp, MyColor.textTertiaryMuted.copy(0.25f), MyShape.small)
            .clip(MyShape.small)
            .clickable { }
            .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall)
    ) {
        TopPinnedLocationView(
            weather.location.name,
            weather.condition,
            weather.tempCel,
            weather.conditionIconUrl
        )
        SpacerXS()
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MyColor.textTertiaryMuted.copy(0.25f))
        )
        SpacerXXS()
        BottomPinnedLocationView(weather = weather)
    }
}

@Composable
private fun BottomPinnedLocationView(modifier: Modifier = Modifier, weather: LocationWeather) {
    Row(modifier = modifier) {
        BottomItem(title = "Wind", value = weather.windKph.toString() + " Km/Hr")
        BottomItem(title = "Humidity", value = weather.humidity.toString() + " %")
        BottomItem(title = "Visibility", value = weather.visibilityKm.toString() + " Km")
    }
}

@Composable
private fun RowScope.BottomItem(title: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(vertical = Paddings.xxxSmall),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MyTypography.SB14, color = MyColor.textTertiary)
        Text(text = value, style = MyTypography.B16, color = MyColor.textPrimary)
    }
}

@Composable
private fun TopPinnedLocationView(
    name: String,
    condition: String,
    tempCel: Double,
    conditionUrl: String
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = MyTypography.B16,
                color = MyColor.textPrimary
            )
            Text(
                text = condition,
                style = MyTypography.SB14,
                color = MyColor.textTertiary
            )
        }
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .height(32.dp)
                .background(MyColor.textTertiaryMuted.copy(0.25f))
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f),
            text = "$tempCel°",
            style = MyTypography.SB24,
            color = MyColor.accentPrimary,
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .height(32.dp)
                .background(MyColor.textTertiaryMuted.copy(0.25f))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f), contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = conditionUrl,
                contentDescription = "",
                modifier = Modifier
                    .size(44.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}