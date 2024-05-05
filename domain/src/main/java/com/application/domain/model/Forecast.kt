package com.application.domain.model

import com.application.data.remote.dto.ForecastWeatherResponse
import com.application.data.remote.dto.Forecastday
import com.application.domain.util.format

data class Forecast(
    val current: LocationWeather,
    val forecastDays: List<ForecastDay>
) {

    companion object {
        fun fromDto(dto: ForecastWeatherResponse) = Forecast(
            current = LocationWeather.fromDto(dto.current, dto.location),
            forecastDays = dto.forecast.forecastday.map {
                ForecastDay.fromDto(it)
            }
        )
    }

    data class ForecastDay(
        val maxTempC: Double,
        val minTempC: Double,
        val avgTempC: Double,
        val chanceOfRain: Double,
        val changeOfSnow: Double,
        val conditionName: String,
        val conditionalUrl: String,
        val date: String
    ) {

        fun getDisplayDate() = format(text = date)

        companion object {
            fun fromDto(dto: Forecastday) = ForecastDay(
                dto.day.maxtempC,
                dto.day.mintempC,
                dto.day.avgtempC,
                dto.day.dailyChanceOfRain,
                dto.day.dailyChanceOfSnow,
                dto.day.condition.text,
                "https://" + dto.day.condition.icon,
                dto.date
            )
        }
    }
}