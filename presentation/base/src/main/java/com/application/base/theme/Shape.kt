package com.application.base.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object Shape {
    val xSmall = RoundedCornerShape(4.dp)
    val small = RoundedCornerShape(6.dp)
    val medium = RoundedCornerShape(12.dp)
    val large = RoundedCornerShape(18.dp)

    val round = RoundedCornerShape(50)

    fun getMaterialShape() = Shapes(
        small = small,
        medium = medium,
        large = large,
        extraLarge = round
    )
}

object Paddings {
    val xxxSmall = 4.dp
    val xxSmall = 8.dp
    val xSmall = 12.dp
    val small = 16.dp
    val medium = 20.dp
    val large = 24.dp
    val xLarge = 28.dp
    val xxLarge = 32.dp
}