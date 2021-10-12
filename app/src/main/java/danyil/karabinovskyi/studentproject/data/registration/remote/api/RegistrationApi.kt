package danyil.karabinovskyi.studentproject.data.registration.remote.api


import danyil.karabinovskyi.studentproject.data.registration.remote.dto.RegistrationResponse
import danyil.karabinovskyi.studentproject.domain.registration.requests.RegistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationApi {
    @POST("auth/registration")
    suspend fun register(@Body registerRequest: RegistrationRequest) : Response<RegistrationResponse>
}