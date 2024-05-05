package com.application.data.remote



object Endpoint {

    const val BASE_URL = "https://api.weatherapi.com/v1"

    val CURRENT_WEATHER = "$BASE_URL/current.json"
    val FORECAST_WEATHER = "$BASE_URL/forecast.json"
    val SEARCH = "$BASE_URL/search.json"
    val FUTURE_WEATHER = "$BASE_URL/future.json"

}