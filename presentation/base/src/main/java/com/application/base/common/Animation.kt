package com.application.base.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

@Composable
fun AnimatedVisibilityFade(
    visible: Boolean,
    enter: EnterTransition = fadeIn(animationSpec = tween(durationMillis = 500)),
    exit: ExitTransition = fadeOut(animationSpec = tween(durationMillis = 500)),
    content: @Composable AnimatedVisibilityScope.() -> Unit
    ) {
    AnimatedVisibility(
        visible = visible,
        enter = enter,
        exit = exit,
        content = content
    )
}