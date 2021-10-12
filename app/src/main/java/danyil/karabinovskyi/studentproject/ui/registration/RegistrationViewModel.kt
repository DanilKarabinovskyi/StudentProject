package danyil.karabinovskyi.studentproject.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import danyil.karabinovskyi.studentproject.base.BaseStateViewModel
import danyil.karabinovskyi.studentproject.base.Result
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.data.registration.remote.dto.RegistrationResponse
import danyil.karabinovskyi.studentproject.domain.login.entity.LoginEntity
import danyil.karabinovskyi.studentproject.domain.registration.entity.RegistrationEntity
import danyil.karabinovskyi.studentproject.domain.registration.requests.RegistrationRequest
import danyil.karabinovskyi.studentproject.domain.registration.usecase.RegistrationUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel@Inject constructor(private val registrationUseCase: RegistrationUseCase): ViewModel() {
    private val state = MutableStateFlow<RegistrationState>(RegistrationState.Init)
    val mState: StateFlow<RegistrationState> get() = state

    init{

    }


    private fun setLoading(){
        state.value = RegistrationState.IsLoading(true)
    }

    private fun hideLoading(){
        state.value = RegistrationState.IsLoading(false)
    }

    private fun showToast(message: String){
        state.value = RegistrationState.ShowToast(message)
    }

    private fun setSuccess(registrationEntity: RegistrationEntity){
        state.value = RegistrationState.Success(registrationEntity)
    }

    private fun setError(rawResponse: WrappedResponse<RegistrationEntity>){
        state.value = RegistrationState.Error(rawResponse)
    }

    fun registrate(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            registrationUseCase.invoke(registrationRequest)
                .onStart {
                    setLoading()
                }
                .catch { exception ->
                    showToast(exception.message.toString())
                    hideLoading()
                }
                .collect { result ->
                    hideLoading()
                    when(result){
                        is Result.Success -> setSuccess(result.data)
                        is Result.Error -> setError(result.rawResponse)
                    }
                }
        }
    }
}

sealed class RegistrationState  {
    object Init : RegistrationState()
    data class IsLoading(val isLoading: Boolean) : RegistrationState()
    data class ShowToast(val message: String) : RegistrationState()
    data class Success(val registrationEntity: RegistrationEntity) : RegistrationState()
    data class Error(val rawResponse: WrappedResponse<RegistrationEntity>) : RegistrationState()
}