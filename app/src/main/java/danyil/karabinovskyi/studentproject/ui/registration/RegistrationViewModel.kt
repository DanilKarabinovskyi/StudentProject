package danyil.karabinovskyi.studentproject.ui.registration

import danyil.karabinovskyi.studentproject.base.BaseStateViewModel
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RegistrationViewModel@Inject constructor(): BaseStateViewModel() {
    private val state = MutableStateFlow<RegistrationState>(RegistrationState.Init)
    val mState: StateFlow<RegistrationState> get() = state


    private fun setLoading(){
        state.value = RegistrationState.IsLoading(true)
    }

    private fun hideLoading(){
        state.value = RegistrationState.IsLoading(false)
    }

    private fun showToast(message: String){
        state.value = RegistrationState.ShowToast(message)
    }

    private fun setSuccess(loginEntity: LoginEntity){
        state.value = RegistrationState.Success(loginEntity)
    }

    private fun setError(rawResponse: WrappedResponse<LoginEntity>){
        state.value = RegistrationState.Error(rawResponse)
    }
}

sealed class RegistrationState  {
    object Init : RegistrationState()
    data class IsLoading(val isLoading: Boolean) : RegistrationState()
    data class ShowToast(val message: String) : RegistrationState()
    data class Success(val loginEntity: LoginEntity) : RegistrationState()
    data class Error(val rawResponse: WrappedResponse<LoginEntity>) : RegistrationState()
}