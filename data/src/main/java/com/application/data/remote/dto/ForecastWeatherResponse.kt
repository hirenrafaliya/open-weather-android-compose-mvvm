package com.application.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class ForecastWeatherResponse (

    @SerialName("location") var location : Location = Location(),
    @SerialName("current") var current : Current = Current(),
    @SerialName("forecast") var forecast : Forecast = Forecast(),
    @SerialName("alerts") var alerts : Alerts = Alerts()

)

@Serializable
data class AirQuality (

    @SerialName("co") var co : Double = 0.0,
    @SerialName("no2") var no2 : Double = 0.0,
    @SerialName("o3") var o3 : Double = 0.0,
    @SerialName("so2") var so2 : Double = 0.0,
    @SerialName("pm2_5") var pm25 : Double = 0.0,
    @SerialName("pm10") var pm10 : Double = 0.0,
    @SerialName("us-epa-index") var usEpaIndex : Double = 0.0,
    @SerialName("gb-defra-index") var gbDefraIndex : Double = 0.0

)
@Serializable
data class Day (

    @SerialName("maxtemp_c") var maxtempC : Double = 0.0,
    @SerialName("maxtemp_f") var maxtempF : Double = 0.0,
    @SerialName("mintemp_c") var mintempC : Double = 0.0,
    @SerialName("mintemp_f") var mintempF : Double = 0.0,
    @SerialName("avgtemp_c") var avgtempC : Double = 0.0,
    @SerialName("avgtemp_f") var avgtempF : Double = 0.0,
    @SerialName("maxwind_mph") var maxwindMph : Double = 0.0,
    @SerialName("maxwind_kph") var maxwindKph : Double = 0.0,
    @SerialName("totalprecip_mm") var totalprecipMm : Double = 0.0,
    @SerialName("totalprecip_in") var totalprecipIn : Double = 0.0,
    @SerialName("totalsnow_cm") var totalsnowCm : Double = 0.0,
    @SerialName("avgvis_km") var avgvisKm : Double = 0.0,
    @SerialName("avgvis_miles") var avgvisMiles : Double = 0.0,
    @SerialName("avghumidity") var avghumidity : Double = 0.0,
    @SerialName("daily_will_it_rain") var dailyWillItRain : Double = 0.0,
    @SerialName("daily_chance_of_rain") var dailyChanceOfRain : Double = 0.0,
    @SerialName("daily_will_it_snow") var dailyWillItSnow : Double = 0.0,
    @SerialName("daily_chance_of_snow") var dailyChanceOfSnow : Double = 0.0,
    @SerialName("condition") var condition : Condition = Condition(),
    @SerialName("uv") var uv : Double = 0.0,
    @SerialName("air_quality") var airQuality : AirQuality = AirQuality()

)
@Serializable
data class Astro (

    @SerialName("sunrise") var sunrise : String = "",
    @SerialName("sunset") var sunset : String = "",
    @SerialName("moonrise") var moonrise : String = "",
    @SerialName("moonset") var moonset : String = "",
    @SerialName("moon_phase") var moonPhase : String = "",
    @SerialName("moon_illumination") var moonIllumination : Double = 0.0,
    @SerialName("is_moon_up") var isMoonUp : Double = 0.0,
    @SerialName("is_sun_up") var isSunUp : Double = 0.0

)
@Serializable
data class Hour (

    @SerialName("time_epoch") var timeEpoch : Double = 0.0,
    @SerialName("time") var time : String = "",
    @SerialName("temp_c") var tempC : Double = 0.0,
    @SerialName("temp_f") var tempF : Double = 0.0,
    @SerialName("is_day") var isDay : Double = 0.0,
    @SerialName("condition") var condition : Condition = Condition(),
    @SerialName("wind_mph") var windMph : Double = 0.0,
    @SerialName("wind_kph") var windKph : Double = 0.0,
    @SerialName("wind_degree") var windDegree : Double = 0.0,
    @SerialName("wind_dir") var windDir : String = "",
    @SerialName("pressure_mb") var pressureMb : Double = 0.0,
    @SerialName("pressure_in") var pressureIn : Double = 0.0,
    @SerialName("precip_mm") var precipMm : Double = 0.0,
    @SerialName("precip_in") var precipIn : Double = 0.0,
    @SerialName("snow_cm") var snowCm : Double = 0.0,
    @SerialName("humidity") var humidity : Double = 0.0,
    @SerialName("cloud") var cloud : Double = 0.0,
    @SerialName("feelslike_c") var feelslikeC : Double = 0.0,
    @SerialName("feelslike_f") var feelslikeF : Double = 0.0,
    @SerialName("windchill_c") var windchillC : Double = 0.0,
    @SerialName("windchill_f") var windchillF : Double = 0.0,
    @SerialName("heatindex_c") var heatindexC : Double = 0.0,
    @SerialName("heatindex_f") var heatindexF : Double = 0.0,
    @SerialName("dewpoint_c") var dewpointC : Double = 0.0,
    @SerialName("dewpoint_f") var dewpointF : Double = 0.0,
    @SerialName("will_it_rain") var willItRain : Double = 0.0,
    @SerialName("chance_of_rain") var chanceOfRain : Double = 0.0,
    @SerialName("will_it_snow") var willItSnow : Double = 0.0,
    @SerialName("chance_of_snow") var chanceOfSnow : Double = 0.0,
    @SerialName("vis_km") var visKm : Double = 0.0,
    @SerialName("vis_miles") var visMiles : Double = 0.0,
    @SerialName("gust_mph") var gustMph : Double = 0.0,
    @SerialName("gust_kph") var gustKph : Double = 0.0,
    @SerialName("uv") var uv : Double = 0.0,
    @SerialName("air_quality") var airQuality : AirQuality = AirQuality()

)
@Serializable
data class Forecastday (

    @SerialName("date") var date : String = "",
    @SerialName("date_epoch") var dateEpoch : Double = 0.0,
    @SerialName("day") var day : Day = Day(),
    @SerialName("astro") var astro : Astro = Astro(),
    @SerialName("hour") var hour : List<Hour>  = listOf()

)
@Serializable
data class Forecast (

    @SerialName("forecastday") var forecastday : List<Forecastday> = listOf()

)
@Serializable
data class Alerts (

    @SerialName("alert") var alert : List<String> = listOf()

)