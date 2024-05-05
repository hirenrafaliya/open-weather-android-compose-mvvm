package com.application.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(private val searchUseCase: SearchUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    fun changeSearchText(text: String) = _uiState.update { it.copy(search = text) }

    fun search() = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = false, error = null) }
        val response = searchUseCase.search(_uiState.value.search)
        response.onSuccess { data ->
            _uiState.update { it.copy(isLoading = false, searchResults = data) }
        }
        response.onFailure { error ->
            _uiState.update { it.copy(isLoading = false, error = error.message) }
        }
    }

    fun clearSearch() = _uiState.update {
        it.copy(search = "", searchResults = listOf())
    }

    fun pinLocation(location: com.application.domain.model.Location) = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = false, error = null) }
        val response = searchUseCase.getCurrentWeather(location.url)
        response.onSuccess { data ->
            _uiState.update {
                it.copy(
                    isLoading = false,
                    pinnedLocations = _uiState.value.pinnedLocations.toMutableList().apply {
                        add(data)
                    }
                )
            }
            clearSearch()
        }
        response.onFailure { error ->
            _uiState.update { it.copy(isLoading = false, error = error.message) }
        }
    }

    fun getCurrentCity(location: android.location.Location) = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = false, error = null) }
        val response = searchUseCase.getCity(location)
        response.onSuccess { data ->
            _uiState.update {
                it.copy(
                    isLoading = false,
                    displayAddress = data.display ?: "",
                    search = data.getSearchQuery()
                )
            }
            search()
        }
        response.onFailure { error ->
            _uiState.update { it.copy(isLoading = false, error = error.message) }
        }
    }

}