package com.application.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    @SerialName("location") var location: Location?  = Location(),
    @SerialName("current") var current: Current? = Current()
)

@Serializable
data class Location(
    @SerialName("name") var name: String = "",
    @SerialName("region") var region: String = "",
    @SerialName("country") var country: String = "",
    @SerialName("lat") var lat: Double = 0.0 ,
    @SerialName("lon") var lon: Double = 0.0 ,
    @SerialName("tz_id") var tzId: String = "",
    @SerialName("localtime_epoch") var localtimeEpoch: Long? = null,
    @SerialName("localtime") var localtime: String = ""
)

@Serializable
data class Current(
    @SerialName("last_updated_epoch") var lastUpdatedEpoch: Long? = null,
    @SerialName("last_updated") var lastUpdated: String = "",
    @SerialName("temp_c") var tempC: Double = 0.0 ,
    @SerialName("temp_f") var tempF: Double = 0.0 ,
    @SerialName("is_day") var isDay: Int? = null,
    @SerialName("condition") var condition: Condition? = null,
    @SerialName("wind_mph") var windMph: Double = 0.0 ,
    @SerialName("wind_kph") var windKph: Double = 0.0 ,
    @SerialName("wind_degree") var windDegree: Int? = null,
    @SerialName("wind_dir") var windDir: String = "",
    @SerialName("pressure_mb") var pressureMb: Double = 0.0 ,
    @SerialName("pressure_in") var pressureIn: Double = 0.0 ,
    @SerialName("precip_mm") var precipMm: Double = 0.0 ,
    @SerialName("precip_in") var precipIn: Double = 0.0 ,
    @SerialName("humidity") var humidity: Double = 0.0 ,
    @SerialName("cloud") var cloud: Double = 0.0 ,
    @SerialName("feelslike_c") var feelsLikeC: Double = 0.0 ,
    @SerialName("feelslike_f") var feelsLikeF: Double = 0.0 ,
    @SerialName("vis_km") var visKm: Double = 0.0 ,
    @SerialName("vis_miles") var visMiles: Double = 0.0 ,
    @SerialName("uv") var uv: Double = 0.0 ,
    @SerialName("gust_mph") var gustMph: Double = 0.0 ,
    @SerialName("gust_kph") var gustKph: Double = 0.0 ,
    @SerialName("air_quality") var airQuality : AirQuality = AirQuality()
) 


@Serializable
data class Condition(
    @SerialName("text") var text: String = "",
    @SerialName("icon") var icon: String = "",
    @SerialName("code") var code: Int? = null
)