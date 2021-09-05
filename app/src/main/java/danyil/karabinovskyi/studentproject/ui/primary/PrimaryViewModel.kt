package danyil.karabinovskyi.studentproject.ui.primary

import dagger.hilt.android.lifecycle.HiltViewModel
import danyil.karabinovskyi.studentproject.base.BaseStateViewModel
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PrimaryViewModel@Inject constructor(): BaseStateViewModel() {
    private val state = MutableStateFlow<PrimaryState>(PrimaryState.Init)
    val mState: StateFlow<PrimaryState> get() = state


    private fun setLoading(){
        state.value = PrimaryState.IsLoading(true)
    }

    private fun hideLoading(){
        state.value = PrimaryState.IsLoading(false)
    }

    private fun showToast(message: String){
        state.value = PrimaryState.ShowToast(message)
    }

    private fun setSuccess(loginEntity: LoginEntity){
        state.value = PrimaryState.Success(loginEntity)
    }

    private fun setError(rawResponse: WrappedResponse<LoginEntity>){
        state.value = PrimaryState.Error(rawResponse)
    }
}

sealed class PrimaryState  {
    object Init : PrimaryState()
    data class IsLoading(val isLoading: Boolean) : PrimaryState()
    data class ShowToast(val message: String) : PrimaryState()
    data class Success(val loginEntity: LoginEntity) : PrimaryState()
    data class Error(val rawResponse: WrappedResponse<LoginEntity>) : PrimaryState()
}