package com.application.base.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

enum class SystemTheme {
    COLOR_LIGHT, COLOR_DARK
}

object SystemConstants {
    // LIGHT/DARK theme
    var systemTheme: SystemTheme by mutableStateOf(SystemTheme.COLOR_LIGHT)
}

val MyColor: ColorDef
    @ReadOnlyComposable
    get() = ColorDef

val MyShape
    @ReadOnlyComposable
    get() = Shape

val MyTypography
    @ReadOnlyComposable
    get() = Typography

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable BoxScope.() -> Unit
) {

    MaterialTheme(colorScheme = MyColor.getMaterialColorScheme(), ) {
        CompositionLocalProvider (LocalRippleTheme provides CustomRippleTheme) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MyColor.bgPrimary),
                content = content
            )
        }
    }
}

private object CustomRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = MyColor.accentPrimary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        MyColor.accentPrimary,
        lightTheme = !isSystemInDarkTheme()
    )
}