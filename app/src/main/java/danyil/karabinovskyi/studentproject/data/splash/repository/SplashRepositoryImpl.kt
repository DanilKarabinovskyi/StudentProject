package danyil.karabinovskyi.studentproject.data.splash.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import danyil.karabinovskyi.studentproject.base.Result
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.data.registration.remote.api.RegistrationApi
import danyil.karabinovskyi.studentproject.data.registration.remote.dto.RegistrationResponse
import danyil.karabinovskyi.studentproject.data.splash.remote.api.SplashApi
import danyil.karabinovskyi.studentproject.domain.registration.RegistrationRepository
import danyil.karabinovskyi.studentproject.domain.registration.entity.RegistrationEntity
import danyil.karabinovskyi.studentproject.domain.registration.requests.RegistrationRequest
import danyil.karabinovskyi.studentproject.domain.splash.SplashRepository
import danyil.karabinovskyi.studentproject.domain.splash.entity.VerifyEntity
import danyil.karabinovskyi.studentproject.domain.splash.requests.VerifyRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(private val splashApi: SplashApi) : SplashRepository {
    override suspend fun verify(verifyRequest: VerifyRequest): Flow<Result<VerifyEntity, WrappedResponse<VerifyEntity>>>{
        return flow {
            val response = registrationApi.register(registrationRequest)
            if (response.isSuccessful){
                val body = response.body()!!
                val registerEntity = RegistrationEntity(token = body.token?:"")
                emit(Result.Success(registerEntity))
            }else{
                val type = object : TypeToken<WrappedResponse<RegistrationResponse>>(){}.type
                val err : WrappedResponse<RegistrationEntity> = Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code().toString()
                emit(Result.Error(err))
            }
        }
    }
}