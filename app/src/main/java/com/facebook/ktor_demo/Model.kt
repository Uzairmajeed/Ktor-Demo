package com.facebook.ktor_demo

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)