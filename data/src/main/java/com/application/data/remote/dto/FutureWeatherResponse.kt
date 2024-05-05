package com.application.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FutureWeatherResponse(
    @SerialName("location") var location: Location,
    @SerialName("forecast") var forecast: Forecast
)