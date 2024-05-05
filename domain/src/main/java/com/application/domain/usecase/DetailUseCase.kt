package com.application.domain.usecase

import com.application.data.repository.WeatherRepository
import com.application.domain.model.Forecast
import com.application.domain.util.safeExecute
import javax.inject.Inject

class DetailUseCase
@Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun getForecastWeather(location: String, days: Int) = safeExecute {
        val response = weatherRepository.getForecastWeather(location = location, days = days)
        Forecast.fromDto(response)
    }
}