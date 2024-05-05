package com.application.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.application.base.common.OnStart
import com.application.base.common.navigateAndClear
import com.application.base.navigation.Screen
import com.application.base.theme.MyColor
import com.application.home.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    OnStart {
        delay(3 * 1000)
        navController.navigateAndClear(Screen.SearchScreen.route)
    }

    SplashScreeUi()
}

@Composable
private fun SplashScreeUi() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MyColor.accentPrimary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_foreground),
            contentDescription = "",
            modifier = Modifier.size(80.dp),
            colorFilter = ColorFilter.tint(MyColor.bgPrimary)
        )
    }
}