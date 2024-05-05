package com.application.search

data class SearchUiState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val search: String = "",
    val city: String = "",
    val region: String = "",
    val displayDate: String = ""
)