package com.application.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OpenStreetResponse(
    @SerialName("address") val address: Address = Address(),
    @SerialName("display_name") val display: String? = ""
) {
    @Serializable
    data class Address(
        @SerialName("suburb") val suburb: String? = "",
        @SerialName("county") val county: String? = "",
        @SerialName("state_district") val district: String? = "",
        @SerialName("city") val city: String? = "",
        @SerialName("country") val country: String? = ""
    )
}