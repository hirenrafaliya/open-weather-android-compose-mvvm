package com.application.domain.util

import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

suspend fun <T> safeExecute(execute: suspend () -> T): Result<T> = try {
    Result.success(execute())
} catch (e: Exception) {
    Log.d("OnError-TAG", "safeExecute: ERROR -> ${e.message}")
    Result.failure(e)
}

enum class DateFormats(val format: String) {
    E_DD_MM_YYYY("E, dd MMM yyyy"),
    YYYY_MM_DD("yyyy-mm-dd")
}

fun format(date: Date, format: String = "dd/MM/yyyy"): String {
    val formatter: DateFormat = SimpleDateFormat(format, Locale.getDefault())
    return formatter.format(date) ?: ""
}

fun format(inFormat: DateFormats = DateFormats.YYYY_MM_DD, text: String, outFormat: DateFormats = DateFormats.E_DD_MM_YYYY): String {
    val date = SimpleDateFormat(inFormat.format, Locale.getDefault()).parse(text) ?: Date()
    val toFormat: DateFormat = SimpleDateFormat(outFormat.format, Locale.getDefault())
    return toFormat.format(date) ?: ""
}
