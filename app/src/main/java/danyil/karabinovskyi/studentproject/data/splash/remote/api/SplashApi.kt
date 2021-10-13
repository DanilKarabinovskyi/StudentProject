package danyil.karabinovskyi.studentproject.data.splash.remote.api

import danyil.karabinovskyi.studentproject.data.splash.remote.dto.VerifyResponse
import danyil.karabinovskyi.studentproject.domain.registration.requests.RegistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SplashApi {
    @POST("auth/verify")
    suspend fun register(@Body registerRequest: RegistrationRequest) : Response<VerifyResponse>
}