package com.application.base.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.application.base.R

val fontFamily = FontFamily(
    Font(R.font.light, FontWeight.Light),
    Font(R.font.regular, FontWeight.Normal),
    Font(R.font.semibold, FontWeight.SemiBold),
    Font(R.font.bold, FontWeight.Bold),
)

object Typography {
    private val default = TextStyle(fontFamily = fontFamily)

    val L12 = default.copy(fontSize = 12.sp, color = ColorDef.textTertiary, fontWeight = FontWeight.Light)
    val L16 = default.copy(fontSize = 16.sp, color = ColorDef.textTertiary, fontWeight = FontWeight.Light)
    val L20 = default.copy(fontSize = 20.sp, color = ColorDef.textTertiary, fontWeight = FontWeight.Light)
    val L24 = default.copy(fontSize = 24.sp, color = ColorDef.textTertiary, fontWeight = FontWeight.Light)

    val SB12 = default.copy(fontSize = 12.sp, color = ColorDef.textPrimaryMuted, fontWeight = FontWeight.SemiBold)
    val SB14 = default.copy(fontSize = 14.sp, color = ColorDef.textPrimaryMuted, fontWeight = FontWeight.SemiBold)
    val SB16 = default.copy(fontSize = 16.sp, color = ColorDef.textPrimaryMuted, fontWeight = FontWeight.SemiBold)
    val SB20 = default.copy(fontSize = 20.sp, color = ColorDef.textPrimaryMuted, fontWeight = FontWeight.SemiBold)
    val SB24 = default.copy(fontSize = 24.sp, color = ColorDef.textPrimaryMuted, fontWeight = FontWeight.SemiBold)

    val N12 = default.copy(fontSize = 12.sp, color = ColorDef.textSecondary, fontWeight = FontWeight.Normal)
    val N14 = default.copy(fontSize = 14.sp, color = ColorDef.textSecondary, fontWeight = FontWeight.Normal)
    val N16 = default.copy(fontSize = 16.sp, color = ColorDef.textSecondary, fontWeight = FontWeight.Normal)
    val N20 = default.copy(fontSize = 20.sp, color = ColorDef.textSecondary, fontWeight = FontWeight.Normal)
    val N24 = default.copy(fontSize = 24.sp, color = ColorDef.textSecondary, fontWeight = FontWeight.Normal)

    val B12 = default.copy(fontSize = 12.sp, color = ColorDef.textPrimary, fontWeight = FontWeight.Bold)
    val B14 = default.copy(fontSize = 14.sp, color = ColorDef.textPrimary, fontWeight = FontWeight.Bold)
    val B16 = default.copy(fontSize = 16.sp, color = ColorDef.textPrimary, fontWeight = FontWeight.Bold)
    val B20 = default.copy(fontSize = 20.sp, color = ColorDef.textPrimary, fontWeight = FontWeight.Bold)
    val B24 = default.copy(fontSize = 24.sp, color = ColorDef.textPrimary, fontWeight = FontWeight.Bold)

    @Composable
    fun getMaterialTypography() = MaterialTheme.typography.copy(

    )
}