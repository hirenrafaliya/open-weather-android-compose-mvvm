package com.application.domain.model

import com.application.data.remote.dto.OpenStreetResponse

data class LocationDetail(
    val subArea: String? = "",
    val area: String? = "",
    val city: String? = "",
    val district: String? = "",
    val country: String? = "",
    val display: String? = ""
) {

    fun getSearchQuery() = when {
        !city.isNullOrBlank() -> city
        !district.isNullOrBlank() -> district
        !country.isNullOrBlank() -> country
        else -> display
    }.toString()

    companion object {
        fun fromDto(dto: OpenStreetResponse) =
            LocationDetail(
                dto.address.suburb,
                dto.address.county,
                dto.address.city,
                dto.address.district,
                dto.address.country,
                dto.display
            )
    }
}