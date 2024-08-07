package org.pradip.cmp

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object KtorClient {

    @OptIn(ExperimentalSerializationApi::class)
    internal val jsonInstance = Json {
        isLenient = true
        prettyPrint = true
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    internal val client = HttpClient() {
        defaultRequest {
            url("https://api.restful-api.dev/")
        }
        install(ContentNegotiation) {
            json(json = jsonInstance)
        }
    }
}