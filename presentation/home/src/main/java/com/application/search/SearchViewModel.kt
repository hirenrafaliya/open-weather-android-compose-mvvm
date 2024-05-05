package com.application.search

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.domain.usecase.SearchUseCase
import com.application.domain.usecase.WeatherUseCase
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

    init {
        onStart()
    }

    private fun onStart() = viewModelScope.launch {
//        searchUseCase.
    }

    fun changeSearchText(text: String) = _uiState.update { it.copy(search = text) }

    fun search() = viewModelScope.launch {

    }

    fun getCurrentCity(location: Location) = viewModelScope.launch {
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