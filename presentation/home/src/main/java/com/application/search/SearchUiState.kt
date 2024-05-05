package com.application.search

import com.application.base.util.DateFormats
import com.application.base.util.format
import com.application.domain.model.Location
import com.application.domain.model.LocationWeather
import java.util.Date

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val search: String = "",
    val displayAddress: String = "",
    val searchResults: List<Location> = listOf(),
    val pinnedLocations: List<LocationWeather> = listOf()
) {
    fun getLocationTitle() = displayAddress
    fun getDisplayDate() = format(Date(), format = DateFormats.E_DD_MM_YYYY.format)
}