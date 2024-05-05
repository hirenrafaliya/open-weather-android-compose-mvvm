package com.application.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.application.base.common.SpacerXS
import com.application.base.common.SpacerXXS
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.domain.model.Forecast


@Composable
fun TomorrowView(day: Forecast.ForecastDay?) {
    Text(text = "TOMORROW", style = MyTypography.B14, color = MyColor.textSecondary)
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
        SpacerXS()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = day?.avgTempC.toString() + "°",
                style = MyTypography.B24.copy(fontSize = 32.sp, color = MyColor.textPrimary),
                textAlign = TextAlign.Center
            )
            SpacerXS()
            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .height(50.dp)
                    .background(MyColor.textTertiaryMuted.copy(0.25f))
            )
            SpacerXS()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                Text(
                    text = day?.conditionName ?: "",
                    style = MyTypography.B16.copy(color = MyColor.textPrimary)
                )
                Text(
                    text = "${day?.chanceOfRain}% Chances of rain",
                    style = MyTypography.SB14.copy(color = MyColor.textTertiary)
                )
            }
            SpacerXS()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.45f), contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = day?.conditionalUrl ?: "",
                    contentDescription = "",
                    modifier = Modifier
                        .size(44.dp),
                    contentScale = ContentScale.Crop
                )
            }
            SpacerXS()
        }

        SpacerXS()

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(MyColor.textTertiaryMuted.copy(0.25f))
        )

        SpacerXS()

        BottomView(day = day)

    }
}

@Composable
private fun BottomView(modifier: Modifier = Modifier, day: Forecast.ForecastDay?) {
    Row(modifier = modifier) {
        BottomItem(title = "Min", value = day?.minTempC.toString() + "°")
        BottomItem(title = "Max", value = day?.maxTempC.toString() + "°")
        BottomItem(title = "Snow Prob.", value = day?.changeOfSnow.toString() + "%")
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
        Text(text = title, style = MyTypography.SB14, color = MyColor.textTertiaryMuted)
        Text(text = value, style = MyTypography.B16, color = MyColor.textSecondary)
    }
}