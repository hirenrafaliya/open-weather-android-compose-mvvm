package com.application.base.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.application.base.theme.MyColor
import com.application.base.theme.Paddings

@Composable
fun ColumnScope.Divider(modifier: Modifier = Modifier, height: Dp = (1).dp, color: Color = MyColor.bgSecondaryMuted) {
    androidx.compose.foundation.layout.Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(color)
    )
}

@Composable
fun RowScope.Divider(modifier: Modifier = Modifier, width: Dp = (1).dp, color: Color = MyColor.bgSecondaryMuted) {
    androidx.compose.foundation.layout.Spacer(
        modifier = modifier
            .fillMaxHeight()
            .width(width)
            .background(color)
    )
}

@Composable
fun Spacer(dp: Dp) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(dp))
}

@Composable
fun SpacerXXXS() = Spacer(dp = Paddings.xxxSmall)

@Composable
fun SpacerXXS() = Spacer(dp = Paddings.xxSmall)

@Composable
fun SpacerXS() = Spacer(dp = Paddings.xSmall)

@Composable
fun SpacerS() = Spacer(dp = Paddings.small)

@Composable
fun SpacerM() = Spacer(dp = Paddings.medium)

@Composable
fun SpacerL() = Spacer(dp = Paddings.large)

@Composable
fun SpacerXL() = Spacer(dp = Paddings.xLarge)

@Composable
fun SpacerXXL() = Spacer(dp = Paddings.xxLarge)

@Composable
fun ColumnScope.SpacerMax() = androidx.compose.foundation.layout.Spacer(modifier = Modifier.fillMaxHeight().weight(1f))

@Composable
fun RowScope.SpacerMax() = androidx.compose.foundation.layout.Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
