package dev.priyam.composeexample.repository

import dev.priyam.composeexample.model.Post
import dev.priyam.composeexample.service.PostApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(val postApiService: PostApiService) {

    fun getPosts(): Flow<List<Post>> = flow {
        emit(postApiService.getPosts())
    }.flowOn(Dispatchers.IO)
}