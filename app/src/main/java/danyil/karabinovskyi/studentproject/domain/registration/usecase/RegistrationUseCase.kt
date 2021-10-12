package danyil.karabinovskyi.studentproject.domain.registration.usecase

import danyil.karabinovskyi.studentproject.base.Result
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.registration.RegistrationRepository
import danyil.karabinovskyi.studentproject.domain.registration.entity.RegistrationEntity
import danyil.karabinovskyi.studentproject.domain.registration.requests.RegistrationRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(private val registrationRepository: RegistrationRepository) {
    suspend fun invoke(registerRequest: RegistrationRequest) : Flow<Result<RegistrationEntity, WrappedResponse<RegistrationEntity>>> {
        return registrationRepository.register(registerRequest)
    }
}