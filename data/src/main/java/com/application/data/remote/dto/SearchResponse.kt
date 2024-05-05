package com.application.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult (
    @SerialName("id") var id : Int,
    @SerialName("name") var name : String,
    @SerialName("region") var region : String,
    @SerialName("country") var country : String,
    @SerialName("lat") var lat : Double,
    @SerialName("lon") var lon : Double,
    @SerialName("url") var url : String
)