package com.application.data.repository

import com.application.data.remote.Endpoint
import com.application.data.remote.dto.CurrentWeatherResponse
import com.application.data.remote.dto.ForecastWeatherResponse
import com.application.data.remote.dto.FutureWeatherResponse
import com.application.data.remote.dto.Search
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

    suspend fun getForecastWeather(location: String, days: Int) =
        client.get(Endpoint.FORECAST_WEATHER) {
            parameter("q", location)
            parameter("days", days)
            parameter("aqi", "yes")
            parameter("alerts", "yes")
            addApiKey()
        }.handleBody<ForecastWeatherResponse>()

    suspend fun getFutureWeather(location: String, date: String) =
        client.get(Endpoint.FUTURE_WEATHER) {
            parameter("q", location)
            parameter("dt", date)
            addApiKey()
        }.handleBody<FutureWeatherResponse>()

    suspend fun search(location: String) =
        client.get(Endpoint.SEARCH) {
            parameter("q", location)
            addApiKey()
        }.handleBody<List<Search>>()
}