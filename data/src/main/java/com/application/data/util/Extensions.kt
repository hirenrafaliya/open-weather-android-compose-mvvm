package com.application.data.util

import android.util.Log
import com.application.data.BuildConfig
import com.application.data.remote.dto.BaseResponse
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json

const val SOMETHING_WENT_WRONG = "Something went wrong!"

// Return tag with class name for all logs
fun Any.tag() = this.javaClass.simpleName + "-TAG"
fun tager(log: Any) = Log.d("TAGER-TAG", log.toString())

// To identify the current build variant
fun isDebug() = BuildConfig.BUILD_TYPE == "debug"
fun isRelease() = BuildConfig.BUILD_TYPE == "release"

suspend inline fun <reified T> HttpResponse.handleBody(): T {
    if (this.status == HttpStatusCode.OK)
        return body<T>()
    else {
        var error: String = SOMETHING_WENT_WRONG
        try {
            val res = Json.decodeFromString<BaseResponse>(this.bodyAsText())
            error = res.error?.message ?: SOMETHING_WENT_WRONG
        } catch (e: Exception) {
            error = this.bodyAsText()
        } finally {
            throw Exception(this.status.value.toString() + " : " + error)
        }
    }
}

fun HttpRequestBuilder.addApiKey() {
    this.parameter("key", SecretManager.get(SecretKeys.API_KEY.key))
}