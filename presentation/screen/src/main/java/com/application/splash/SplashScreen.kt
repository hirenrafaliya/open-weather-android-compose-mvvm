package com.application.splash

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.application.base.common.OnStart
import com.application.base.common.navigateAndClear
import com.application.base.navigation.Screen
import com.application.base.theme.MyColor
import com.application.home.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current

    fun navigate() = navController.navigateAndClear(Screen.SearchScreen.route)

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { _: Boolean ->
        navigate()
    }

    OnStart {
        delay(2 * 1000)
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            launcher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
        } else {
            navigate()
        }
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