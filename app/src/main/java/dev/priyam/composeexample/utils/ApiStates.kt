package dev.priyam.composeexample.utils

import dev.priyam.composeexample.model.Post

sealed class ApiStates {
    class Success(val data: List<Post>) : ApiStates()
    class Failure(val msg: Throwable) : ApiStates()
    object Loading : ApiStates()
    object Empty : ApiStates()
}
