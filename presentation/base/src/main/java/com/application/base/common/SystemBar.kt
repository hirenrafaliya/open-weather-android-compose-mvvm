package com.application.base.common

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.application.base.theme.SystemConstants
import com.application.base.theme.SystemTheme

@Composable
fun SystemBarForegroundColor(isLight: Boolean, force: Boolean = false) {
    val color = if (force) isLight else {
        if (SystemConstants.systemTheme == SystemTheme.COLOR_DARK) !isLight else isLight
    }
    StatusBarForegroundColor(isLight = color)
    NavigationBarForegroundColor(isLight = color)
}

@Composable
fun StatusBarForegroundColor(isLight: Boolean) {
    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window

        WindowCompat.getInsetsController(window, view)
            .isAppearanceLightStatusBars = !isLight
    }
}

@Composable
fun NavigationBarForegroundColor(isLight: Boolean) {
    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window

        WindowCompat.getInsetsController(window, view)
            .isAppearanceLightNavigationBars = !isLight
    }
}