package com.facebook.ktor_demo

import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpRedirect
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse

class GetRepository {
    private val client = HttpClient(Android){
        followRedirects = false
        expectSuccess = false
    }

    suspend fun getFromServer(): String? {
            val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts/1")
            val responseBody = response.receive<String>()
            return responseBody
    }
    suspend fun postToGoogleSheets(title: String, body: String): String? {
        val response: HttpResponse = client.post("https://script.google.com/macros/s/AKfycbypdtnMirtcA8oo90J8iJEHJTkJH5m8eF_nezB8k4JHuozq47aeUn0aioxqv-YLFphB/exec")
        {
            url("https://script.google.com/macros/s/AKfycbypdtnMirtcA8oo90J8iJEHJTkJH5m8eF_nezB8k4JHuozq47aeUn0aioxqv-YLFphB/exec?action=addItem&title=$title&body=$body")
        }
        return response.receive<String>()
    }
}
