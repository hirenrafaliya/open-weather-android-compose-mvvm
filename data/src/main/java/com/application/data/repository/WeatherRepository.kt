package com.application.data.repository

import com.application.data.remote.Endpoint
import com.application.data.remote.dto.CurrentWeatherResponse
import com.application.data.util.addApiKey
import com.application.data.util.handleBody
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class WeatherRepository
@Inject constructor(private val client: HttpClient) {

    suspend fun getCurrentWeather(location: String) =
        client.get(Endpoint.CURRENT_WEATHER) {
            parameter("q", location)
            addApiKey()
        }.handleBody<CurrentWeatherResponse>()
}