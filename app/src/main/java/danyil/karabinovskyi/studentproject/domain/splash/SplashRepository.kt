package danyil.karabinovskyi.studentproject.domain.splash

import danyil.karabinovskyi.studentproject.base.Result
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.domain.splash.entity.VerifyEntity
import danyil.karabinovskyi.studentproject.domain.splash.requests.VerifyRequest
import kotlinx.coroutines.flow.Flow

interface SplashRepository {
    suspend fun verify(verifyRequest: VerifyRequest) : Flow<Result<VerifyEntity, WrappedResponse<VerifyEntity>>>
}