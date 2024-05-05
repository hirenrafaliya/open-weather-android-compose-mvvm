package com.application.data.repository

import io.ktor.client.HttpClient
import javax.inject.Inject

class WeatherRepository
@Inject constructor(private val client: HttpClient) {

}