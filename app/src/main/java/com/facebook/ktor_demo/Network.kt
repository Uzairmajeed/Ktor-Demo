package com.facebook.ktor_demo

import com.google.gson.Gson

class Network {
    private val getRepository=GetRepository()
    suspend fun fetchData(): Post? {
        return try {
            val responseBody =  getRepository.getFromServer()
            val post = Gson().fromJson(responseBody, Post::class.java)
            post
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
