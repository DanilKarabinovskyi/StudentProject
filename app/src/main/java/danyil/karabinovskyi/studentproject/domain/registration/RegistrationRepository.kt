package danyil.karabinovskyi.studentproject.domain.registration

import danyil.karabinovskyi.studentproject.base.Result
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.registration.entity.RegistrationEntity
import danyil.karabinovskyi.studentproject.domain.registration.requests.RegistrationRequest
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository {
    suspend fun register(registrationRequest: RegistrationRequest) : Flow<Result<RegistrationEntity, WrappedResponse<RegistrationEntity>>>
}