package com.application.base.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object ColorDef {
    val bgPrimary = color(Color(0xFFFFFFFF), Color(0xFF1A1A1A))
    val bgPrimaryMuted = color(Color(0x33FFFFFF), Color(0xFF1E1E1E))

    val bgSecondary = color(Color(0xCCFFFFFF), Color(0xFF2B2B2B))
    val bgSecondaryMuted = color(Color(0x66FFFFFF), Color(0xFF3D3D3D))

    val bgTertiary = color(Color(0x99FFFFFF), Color(0xFF5C5C5C))
    val bgTertiaryMuted = color(Color(0x1AE0E0E0), Color(0xFFDDDDDD))

    val textPrimary = color(Color(0xFF000000), Color(0xFFFFFFFF))
    val textPrimaryMuted = color(Color(0xFF181818), Color(0xBFFFFFFF))

    val textSecondary = color(Color(0xFF252525), Color(0x99FFFFFF))
    val textSecondaryMuted = color(Color(0xFF414141), Color(0x66FFFFFF))

    val textTertiary = color(Color(0xFF6B6B6B), Color(0x40FFFFFF))
    val textTertiaryMuted = color(Color(0xFF8B8B8B), Color(0x0DFFFFFF))

    val accentPrimary = color(Color(0xFF007AFF), Color(0xFF26B661))
    val accentPrimaryMuted = color(Color(0xFFDAEBFF), Color(0xFF416AFF))

    val accentLightPrimary = color(Color(0xFF48A0FF), Color(0xBF2C6847))
    val accentLightSecondary = color(Color(0xFF92C7FF), Color(0xBF1F3F2D))

    val redPrimary = color(Color(0xFFF44336), Color(0xFFF44336))
    val redSecondary = color(Color(0xFFF5655B), Color(0x4D5A2523))

    val yellowPrimary = color(Color(0xFFFFAB2E), Color(0xFFFAE52F))
    val yellowSecondary = color(Color(0xFFFAEE8B), Color(0xBF83781F))

    val greenPrimary = color(Color(0xFF49F436), Color(0xFF49F436))
    val greenPrimaryText = color(Color(0xFF16B804), Color(0xFF49F436))
    val greenSecondary = color(Color(0xFFE2FDDF), Color(0xBF52774F))

    val tealPrimary = color(Color(0xFF26B661), Color(0xFF26B661))
    val tealSecondary = color(Color(0xFFA9F8A1), Color(0xFFA9F8A1))

    val whitePrimary = color(Color(0xFFFFFFFF), Color(0xFF000000))
    val blackPrimary = color(Color(0xFF000000), Color(0xFFFFFFFF))

    val bgGradient = listOf(Color(0xFF0B43CA), Color(0xFF2b62e9))

    @Composable
    fun getMaterialColorScheme(): ColorScheme =
        MaterialTheme.colorScheme.copy(background = bgPrimary, primary = accentPrimary, primaryContainer = accentLightPrimary.copy(0.15f), onBackground = textPrimary)
}


private fun color(light: Color, dark: Color) =
    if (SystemConstants.systemTheme == SystemTheme.COLOR_DARK) dark else light