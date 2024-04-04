package com.baptistecarlier.am24.shared.data.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient(private val debug: Boolean = false) {

    private val tag = "OhMyGoatApp"

    val httpClient: HttpClient
        get() = HttpClient {
            defaultRequest {
                url.protocol = URLProtocol.HTTPS
            }

            // Only on Debug (⌐■_■)
            if (debug) {
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.d(tag, message)
                        }
                    }
                    level = LogLevel.ALL
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        // if the server sends extra fields, ignore them
                        ignoreUnknownKeys = true
                    },
                )
            }
        }
}