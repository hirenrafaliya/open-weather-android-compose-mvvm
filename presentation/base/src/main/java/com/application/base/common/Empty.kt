package com.application.base.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.application.base.theme.MyColor
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings

// For empty loading states
@Composable
fun Empty(modifier: Modifier = Modifier, text: String, color: Color = MyColor.textTertiary) {
    Column(
        modifier = modifier.padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, style = MyTypography.SB14, color = color)
    }
}