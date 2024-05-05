package com.application.detail

import com.application.domain.model.Forecast
import com.application.domain.util.DateFormats
import com.application.domain.util.format
import java.util.Date

data class DetailUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val forecast: Forecast? = null,
    val isRefreshing: Boolean = false
) {
    fun getLocationTitle() =
        forecast?.current?.location?.name + "," + forecast?.current?.location?.region + "," + forecast?.current?.location?.country

    fun getDisplayDate() = format(Date(), format = DateFormats.E_DD_MM_YYYY.format)
}