package com.example.retrofit.interfaces

import com.example.retrofit.model.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("post/{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    @POST("posts")
    suspend fun createPost(@Body post: Post): Post
}