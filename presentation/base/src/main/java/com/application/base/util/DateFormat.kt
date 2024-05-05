package com.application.base.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class DateFormats(val format: String) {
    E_DD_MM_YYYY("E, dd MMM yyyy")
}

fun format(date: Date, format: String = "dd/MM/yyyy"): String {
    val formatter: DateFormat = SimpleDateFormat(format, Locale.getDefault())
    return formatter.format(date) ?: ""
}
