package com.application.data.repository

import com.application.data.remote.Endpoint
import com.application.data.remote.dto.OpenStreetResponse
import com.application.data.remote.dto.Search
import com.application.data.util.addApiKey
import com.application.data.util.handleBody
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class SearchRepository
@Inject constructor(private val client: HttpClient) {

    suspend fun search(location: String) =
        client.get(Endpoint.SEARCH) {
            parameter("q", location)
            addApiKey()
        }.handleBody<List<Search>>()

    suspend fun getCity(lat: String, lng: String) =
        client.get(Endpoint.GET_CITY) {
            parameter("lat", lat)
            parameter("lon", lng)
            addApiKey()
        }.handleBody<OpenStreetResponse>()
}