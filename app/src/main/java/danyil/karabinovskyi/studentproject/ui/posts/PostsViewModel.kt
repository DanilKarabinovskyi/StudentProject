package danyil.karabinovskyi.studentproject.ui.posts

import danyil.karabinovskyi.studentproject.base.BaseStateViewModel
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class PostsViewModel@Inject constructor(): BaseStateViewModel() {
    private val state = MutableStateFlow<PostsState>(PostsState.Init)
    val mState: StateFlow<PostsState> get() = state


    private fun setLoading(){
        state.value = PostsState.IsLoading(true)
    }

    private fun hideLoading(){
        state.value = PostsState.IsLoading(false)
    }

    private fun showToast(message: String){
        state.value = PostsState.ShowToast(message)
    }

    private fun setSuccess(loginEntity: LoginEntity){
        state.value = PostsState.Success(loginEntity)
    }

    private fun setError(rawResponse: WrappedResponse<LoginEntity>){
        state.value = PostsState.Error(rawResponse)
    }
}

sealed class PostsState  {
    object Init : PostsState()
    data class IsLoading(val isLoading: Boolean) : PostsState()
    data class ShowToast(val message: String) : PostsState()
    data class Success(val loginEntity: LoginEntity) : PostsState()
    data class Error(val rawResponse: WrappedResponse<LoginEntity>) : PostsState()
}