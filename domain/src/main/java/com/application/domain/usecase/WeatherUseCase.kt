package com.application.domain.usecase

import com.application.data.repository.WeatherRepository
import com.application.domain.util.safeExecute
import javax.inject.Inject

class WeatherUseCase
@Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun getCurrentWeather(location: String) = safeExecute {
        weatherRepository.getCurrentWeather(location = location)
    }

    suspend fun getFutureWeather(location: String, date: String) = safeExecute {
        weatherRepository.getFutureWeather(location = location, date = date)
    }

    suspend fun getForecastWeather(location: String, days: Int) = safeExecute {
        weatherRepository.getForecastWeather(location = location, days = days)
    }

    suspend fun search(location: String) = safeExecute {
        weatherRepository.search(location = location)
    }
}