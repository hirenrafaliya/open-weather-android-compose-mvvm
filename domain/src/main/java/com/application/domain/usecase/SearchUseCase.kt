package com.application.domain.usecase

import android.location.Location
import com.application.data.repository.SearchRepository
import com.application.domain.model.LocationDetail
import com.application.domain.model.LocationWeather
import com.application.domain.util.safeExecute
import javax.inject.Inject

class SearchUseCase
@Inject constructor(private val searchRepository: SearchRepository) {

    suspend fun getCity(location: Location) = safeExecute {
        val response =
            searchRepository.getCity(location.latitude.toString(), location.longitude.toString())

        LocationDetail.fromDto(response)
    }

    suspend fun search(query: String) = safeExecute {
        val response =
            searchRepository.search(query)
        response.map {
            com.application.domain.model.Location.fromDto(it)
        }
    }

    suspend fun getCurrentWeather(location: String) = safeExecute {
        val response =
            searchRepository.getCurrentWeather(location = location)
        LocationWeather.fromDto(response)
    }

}