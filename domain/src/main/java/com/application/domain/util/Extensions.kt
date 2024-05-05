package com.application.domain.util

import android.util.Log

suspend fun <T> safeExecute(execute: suspend () -> T): Result<T> = try {
    Result.success(execute())
} catch (e: Exception) {
    Log.d("OnError-TAG", "safeExecute: ERROR -> ${e.message}")
    Result.failure(e)
}