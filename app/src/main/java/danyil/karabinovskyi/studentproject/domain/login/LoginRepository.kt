package danyil.karabinovskyi.studentproject.domain.login

import danyil.karabinovskyi.studentproject.domain.login.requests.LoginRequest

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest)
//    : Flow<BaseResult<LoginEntity, WrappedResponse<LoginEntity>>>
}