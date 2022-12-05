package dev.priyam.composeexample.service

import dev.priyam.composeexample.model.Post
import retrofit2.http.GET

interface PostApiService {
    companion object{
        const val BASE_URL="https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPosts():List<Post>
}