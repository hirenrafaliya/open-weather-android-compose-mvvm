package com.application.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.application.base.common.tager
import com.application.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject constructor(
    private val weatherUseCase: WeatherUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val locationUrl: String = savedStateHandle["location_url"] ?: ""

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    init {
        tager(locationUrl)
    }
}