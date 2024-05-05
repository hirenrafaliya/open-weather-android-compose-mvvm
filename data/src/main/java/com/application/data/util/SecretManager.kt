package com.application.data.util

import com.staarsign.data.util.isRelease

/**
 * Handles all secret key variables for the app
 */
object SecretManager {
    init {
        System.loadLibrary("native-lib")
    }

    private external fun getSecretKey(key: String): String
    fun get(key: String): String =
        when  {
            isRelease() -> {
                getSecretKey(key)
            }

            else -> {
                getSecretKey(key)
            }
        }

    private fun getDebugValues(key: String) = when (key) {
        SecretKeys.API_KEY.key -> "DEBUG-API-KEY"
        else -> "DEBUG"
    }
}

enum class SecretKeys(val key: String) {
    API_KEY("1")
}