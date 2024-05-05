package com.application.data.remote.dto

import com.application.data.util.SOMETHING_WENT_WRONG
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(
    @SerialName("error") val error: Error? = null,
) {
    @Serializable
    data class Error(
        @SerialName("code") val code: Int? = 0,
        @SerialName("message") val message: String? = SOMETHING_WENT_WRONG
    )
}