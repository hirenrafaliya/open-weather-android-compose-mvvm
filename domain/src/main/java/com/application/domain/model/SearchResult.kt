package com.application.domain.model

import com.application.data.remote.dto.Search

data class SearchResult(
    var id: Int,
    var name: String,
    var region: String,
    var country: String
) {
    companion object {
        fun fromDto(dto: Search) = SearchResult(
            dto.id, dto.name, dto.region, dto.country
        )
    }
}