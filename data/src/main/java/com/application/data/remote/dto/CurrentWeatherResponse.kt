package com.application.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    @SerialName("location") var location: Location? = Location(),
    @SerialName("current") var current: Current? = Current()
) {

    @Serializable
    data class Location(
        @SerialName("name") var name: String? = null,
        @SerialName("region") var region: String? = null,
        @SerialName("country") var country: String? = null,
        @SerialName("lat") var lat: Double? = null,
        @SerialName("lon") var lon: Double? = null,
        @SerialName("tz_id") var tzId: String? = null,
        @SerialName("localtime_epoch") var localtimeEpoch: Long? = null,
        @SerialName("localtime") var localtime: String? = null
    )

    @Serializable
    data class Current(
        @SerialName("last_updated_epoch") var lastUpdatedEpoch: Long? = null,
        @SerialName("last_updated") var lastUpdated: String? = null,
        @SerialName("temp_c") var tempC: Double? = null,
        @SerialName("temp_f") var tempF: Double? = null,
        @SerialName("is_day") var isDay: Int? = null,
        @SerialName("condition") var condition: Condition? = Condition(),
        @SerialName("wind_mph") var windMph: Double? = null,
        @SerialName("wind_kph") var windKph: Double? = null,
        @SerialName("wind_degree") var windDegree: Int? = null,
        @SerialName("wind_dir") var windDir: String? = null,
        @SerialName("pressure_mb") var pressureMb: Double? = null,
        @SerialName("pressure_in") var pressureIn: Double? = null,
        @SerialName("precip_mm") var precipMm: Double? = null,
        @SerialName("precip_in") var precipIn: Double? = null,
        @SerialName("humidity") var humidity: Double? = null,
        @SerialName("cloud") var cloud: Double? = null,
        @SerialName("feelslike_c") var feelsLikeC: Double? = null,
        @SerialName("feelslike_f") var feelsLikeF: Double? = null,
        @SerialName("vis_km") var visKm: Double? = null,
        @SerialName("vis_miles") var visMiles: Double? = null,
        @SerialName("uv") var uv: Double? = null,
        @SerialName("gust_mph") var gustMph: Double? = null,
        @SerialName("gust_kph") var gustKph: Double? = null

    ) {

        @Serializable
        data class Condition(
            @SerialName("text") var text: String? = null,
            @SerialName("icon") var icon: String? = null,
            @SerialName("code") var code: Int? = null
        )
    }

}