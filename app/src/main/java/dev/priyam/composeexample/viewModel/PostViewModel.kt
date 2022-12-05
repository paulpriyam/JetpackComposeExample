package dev.priyam.composeexample.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.priyam.composeexample.repository.PostRepository
import dev.priyam.composeexample.utils.ApiStates
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel
@Inject
constructor(private val postRepository: PostRepository) : ViewModel() {

    val response: MutableState<ApiStates> = mutableStateOf(ApiStates.Empty)

    init {
        getPost()
    }

    fun getPost() = viewModelScope.launch {

        postRepository.getPosts()
            .onStart {
                response.value = ApiStates.Loading
            }.catch {
                response.value = ApiStates.Failure(it)
            }.collect {
                response.value = ApiStates.Success(it)
            }
    }
}