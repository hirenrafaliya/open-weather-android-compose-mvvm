package com.application.base.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.application.base.theme.MyColor
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings

@Composable
fun ErrorView(modifier: Modifier = Modifier, error: String) {
    AnimatedVisibility(visible = error.isNotBlank()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(MyColor.redSecondary.copy(0.15f))
                .navigationBarsPadding()
                .padding(horizontal = Paddings.xSmall, vertical = Paddings.xSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = error, style = MyTypography.SB16, color = MyColor.redPrimary)
        }
    }
}