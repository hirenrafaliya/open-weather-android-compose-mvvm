package com.application.data.util

import android.util.Log

const val SOMETHING_WENT_WRONG = "Something went wrong!"

// Return tag with class name for all logs
fun Any.tag() = this.javaClass.simpleName + "-TAG"
fun tager(log: Any) = Log.d("TAGER-TAG", log.toString())

// To identify the current build variant
fun isDebug() = true
fun isRelease() = false
