package com.application.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.application.base.common.AnimatedVisibilityFade
import com.application.base.common.SpacerXS
import com.application.base.common.SpacerXXS
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.domain.model.Forecast


@Composable
fun NextDaysView(days: List<Forecast.ForecastDay>) {
    AnimatedVisibilityFade(visible = days.isNotEmpty()) {
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
//                    .border(0.8.dp, MyColor.textTertiaryMuted.copy(0.25f), MyShape.small)
                    .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall)
            ) {
                days.forEachIndexed { index, forecastDay ->
                    NextDayItem(day = forecastDay, showDivider = index != days.lastIndex)
                }
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
