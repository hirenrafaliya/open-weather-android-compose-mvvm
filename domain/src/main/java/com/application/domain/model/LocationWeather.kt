package com.application.domain.model

import com.application.data.remote.dto.Current
import com.application.data.remote.dto.CurrentWeatherResponse

data class LocationWeather(
    val lastUpdate: String,
    val tempCel: Double,
    val condition: String,
    val conditionIconUrl: String,
    val windKph: Double,
    val windDegree: Int,
    val humidity: Double,
    val cloud: Double,
    val feelTemp: Double,
    val visibilityKm: Double,
    val uv: Double,
    val gustKph: Double,
    val location: Location
) {
    companion object {
        fun fromDto(dto: CurrentWeatherResponse) = LocationWeather(
            dto.current?.lastUpdated ?: "",
            dto.current?.tempC ?: 0.0,
            dto.current?.condition?.text ?: "",
            ("https://" + dto.current?.condition?.icon) ?: "",
            dto.current?.windKph ?: 0.0,
            dto.current?.windDegree ?: 0,
            dto.current?.humidity ?: 0.0,
            dto.current?.cloud ?: 0.0,
            dto.current?.feelsLikeC ?: 0.0,
            dto.current?.visKm ?: 0.0,
            dto.current?.uv ?: 0.0,
            dto.current?.gustKph ?: 0.0,
            Location.fromDto(dto.location)
        )

        fun fromDto(dto: Current, location: com.application.data.remote.dto.Location) = LocationWeather(
            dto.lastUpdated ?: "",
            dto.tempC ?: 0.0,
            dto.condition?.text ?: "",
            ("https://" + dto.condition?.icon) ?: "",
            dto.windKph ?: 0.0,
            dto.windDegree ?: 0,
            dto.humidity ?: 0.0,
            dto.cloud ?: 0.0,
            dto.feelsLikeC ?: 0.0,
            dto.visKm ?: 0.0,
            dto.uv ?: 0.0,
            dto.gustKph ?: 0.0,
            Location.fromDto(location)
        )
    }
}