package danyil.karabinovskyi.studentproject.ui.login

import dagger.hilt.android.lifecycle.HiltViewModel
import danyil.karabinovskyi.studentproject.base.BaseStateViewModel
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(): BaseStateViewModel() {
    private val state = MutableStateFlow<LoginState>(LoginState.Init)
    val mState: StateFlow<LoginState> get() = state


    private fun setLoading(){
        state.value = LoginState.IsLoading(true)
    }

    private fun hideLoading(){
        state.value = LoginState.IsLoading(false)
    }

    private fun showToast(message: String){
        state.value = LoginState.ShowToast(message)
    }

    private fun setSuccess(loginEntity: LoginEntity){
        state.value = LoginState.Success(loginEntity)
    }

    private fun setError(rawResponse: WrappedResponse<LoginEntity>){
        state.value = LoginState.Error(rawResponse)
    }
}

sealed class LoginState  {
    object Init : LoginState()
    data class IsLoading(val isLoading: Boolean) : LoginState()
    data class ShowToast(val message: String) : LoginState()
    data class Success(val loginEntity: LoginEntity) : LoginState()
    data class Error(val rawResponse: WrappedResponse<LoginEntity>) : LoginState()
}