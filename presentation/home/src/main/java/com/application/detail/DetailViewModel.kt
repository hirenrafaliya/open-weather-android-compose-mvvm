package com.application.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.domain.usecase.DetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject constructor(
    private val detailUseCase: DetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val locationUrl: String = savedStateHandle["location_url"] ?: ""

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getForecast()
    }

    private fun getForecast() = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = false, error = null) }
        val response = detailUseCase.getForecastWeather(locationUrl, 15)
        response.onSuccess { data ->
            _uiState.update { it.copy(isLoading = false, forecast = data) }
        }
        response.onFailure { error ->
            _uiState.update { it.copy(isLoading = false, error = error.message) }

        }
    }
}