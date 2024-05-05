package com.application.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(private val weatherUseCase: WeatherUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    init {
        onStart()
    }

    private fun onStart()  = viewModelScope.launch {
        weatherUseCase.search("Surat")
    }

}