package danyil.karabinovskyi.studentproject.data.splash

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import danyil.karabinovskyi.studentproject.data.registration.remote.api.RegistrationApi
import danyil.karabinovskyi.studentproject.data.registration.repository.RegistrationRepositoryImpl
import danyil.karabinovskyi.studentproject.data.splash.remote.api.SplashApi
import danyil.karabinovskyi.studentproject.data.splash.repository.SplashRepositoryImpl
import danyil.karabinovskyi.studentproject.di.NetworkModule
import danyil.karabinovskyi.studentproject.domain.registration.RegistrationRepository
import danyil.karabinovskyi.studentproject.domain.splash.SplashRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class SplashModule {
    @Singleton
    @Provides
    fun provideSplashApi(retrofit: Retrofit) : RegistrationApi {
        return retrofit.create(RegistrationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSplashRepository(splashApi: SplashApi) : SplashRepository {
        return SplashRepositoryImpl(splashApi)
    }
}