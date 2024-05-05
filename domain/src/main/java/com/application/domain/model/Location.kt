package com.application.domain.model

import com.application.data.remote.dto.SearchResult

data class Location(
    var id: Int,
    var name: String,
    var region: String,
    var country: String,
    val url: String
) {
    companion object {
        fun fromDto(dto: SearchResult) = Location(
            dto.id, dto.name, dto.region, dto.country, dto.url
        )

        fun fromDto(dto: com.application.data.remote.dto.Location?) = Location(
            0,
            dto?.name ?: "",
            dto?.region ?: "",
            dto?.country ?: "",
            (dto?.name + " " + dto?.region + " " + dto?.country).lowercase().replace(" ", "-")
        )
    }
}