package com.application.domain.usecase

import com.application.data.repository.WeatherRepository
import com.application.domain.util.safeExecute
import javax.inject.Inject

class WeatherUseCase
@Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun getCurrentWeather(location: String) = safeExecute {
        weatherRepository.getCurrentWeather(location = location)
    }
}