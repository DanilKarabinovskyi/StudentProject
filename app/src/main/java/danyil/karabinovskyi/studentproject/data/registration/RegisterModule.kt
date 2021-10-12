package danyil.karabinovskyi.studentproject.data.registration

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import danyil.karabinovskyi.studentproject.data.registration.remote.api.RegistrationApi
import danyil.karabinovskyi.studentproject.data.registration.repository.RegistrationRepositoryImpl
import danyil.karabinovskyi.studentproject.di.NetworkModule
import danyil.karabinovskyi.studentproject.domain.registration.RegistrationRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class RegisterModule {
    @Singleton
    @Provides
    fun provideRegisterApi(retrofit: Retrofit) : RegistrationApi {
        return retrofit.create(RegistrationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRegisterRepository(registrationApi: RegistrationApi) : RegistrationRepository {
        return RegistrationRepositoryImpl(registrationApi)
    }
}