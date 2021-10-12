package danyil.karabinovskyi.studentproject.data.login.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import danyil.karabinovskyi.studentproject.data.login.remote.api.LoginApi
import danyil.karabinovskyi.studentproject.domain.login.LoginRepository
import danyil.karabinovskyi.studentproject.domain.login.requests.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(private val loginApi: LoginApi) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest) {
        TODO("Not yet implemented")
    }
//    override suspend fun login(loginRequest: LoginRequest): Flow<Result<LoginEntity, WrappedResponse<LoginEntity>>> {
//
//    }
}
