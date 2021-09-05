package danyil.karabinovskyi.studentproject.ui.events

import danyil.karabinovskyi.studentproject.base.BaseStateViewModel
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class EventsViewModel@Inject constructor(): BaseStateViewModel() {
    private val state = MutableStateFlow<EventsState>(EventsState.Init)
    val mState: StateFlow<EventsState> get() = state


    private fun setLoading(){
        state.value = EventsState.IsLoading(true)
    }

    private fun hideLoading(){
        state.value = EventsState.IsLoading(false)
    }

    private fun showToast(message: String){
        state.value = EventsState.ShowToast(message)
    }

    private fun setSuccess(loginEntity: LoginEntity){
        state.value = EventsState.Success(loginEntity)
    }

    private fun setError(rawResponse: WrappedResponse<LoginEntity>){
        state.value = EventsState.Error(rawResponse)
    }
}

sealed class EventsState  {
    object Init : EventsState()
    data class IsLoading(val isLoading: Boolean) : EventsState()
    data class ShowToast(val message: String) : EventsState()
    data class Success(val loginEntity: LoginEntity) : EventsState()
    data class Error(val rawResponse: WrappedResponse<LoginEntity>) : EventsState()
}