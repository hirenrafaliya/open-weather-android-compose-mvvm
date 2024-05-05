package com.application.data.remote.di

import android.util.Log
import com.application.data.remote.Endpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {

            defaultRequest {
                host = Endpoint.BASE_URL
                url { protocol = URLProtocol.HTTPS }
                contentType(ContentType.Application.Json)
            }

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    explicitNulls = false
                })
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("KTOR-LOG: ", "${response.status.value}")
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("KTOR-LOG: ", message)
                    }
                }
                level = LogLevel.BODY
            }

            defaultRequest {

            }
        }
    }
}