package com.application.base.common

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController

// Used in UiStates
fun Boolean.ifTrue(callback: () -> Unit, then: () -> Unit) {
    if (this) callback.invoke()
    then.invoke()
}

fun Any?.ifNonNull(callback: () -> Unit, then: () -> Unit) {
    if (this != null) callback.invoke()
    then.invoke()
}

fun <T : Any> Any?.ifNonNull(callback: (T) -> Unit, then: () -> Unit) {
    if (this != null) callback.invoke(this as T)
    then.invoke()
}

// A wrapper around LaunchedEffect
@Composable
fun OnStart(key: Any = Unit, callback: suspend () -> Unit) {
    LaunchedEffect(key) {
        callback.invoke()
    }
}


fun NavHostController.navigateAndClear(route: String) {
    this.popBackStack()
    this.navigate(route)
}

// Return tag with class name for all logs
fun Any.tag() = this.javaClass.simpleName + "-TAG"
fun tager(log: Any) = Log.d("TAGER", log.toString())