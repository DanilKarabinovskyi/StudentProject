package danyil.karabinovskyi.studentproject.data.login.remote.api

import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.data.login.remote.dto.LoginResponse
import danyil.karabinovskyi.studentproject.domain.login.requests.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest) : Response<WrappedResponse<LoginResponse>>
}