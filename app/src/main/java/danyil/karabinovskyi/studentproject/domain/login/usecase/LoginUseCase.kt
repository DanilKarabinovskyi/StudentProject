package danyil.karabinovskyi.studentproject.domain.login.usecase


import danyil.karabinovskyi.studentproject.domain.login.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
//    suspend fun execute(loginRequest: LoginRequest): Flow<BaseResult<LoginEntity, WrappedResponse<LoginEntity>>> {
//        return loginRepository.login(loginRequest)
//    }

}