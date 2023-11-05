package com.facebook.ktor_demo

import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.engine.android.Android
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class GetRepository {
    private val client = HttpClient(Android)

    suspend fun getFromServer(): String? {
            val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts/1")
            val responseBody = response.receive<String>()
            return responseBody
    }
}
