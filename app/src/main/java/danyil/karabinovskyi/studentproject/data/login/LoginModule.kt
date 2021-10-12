package danyil.karabinovskyi.studentproject.data.login


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import danyil.karabinovskyi.studentproject.data.login.remote.api.LoginApi
import danyil.karabinovskyi.studentproject.data.login.repository.LoginRepositoryImpl
import danyil.karabinovskyi.studentproject.di.NetworkModule
import danyil.karabinovskyi.studentproject.domain.login.LoginRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Singleton
    @Provides
    fun provideLoginApi(retrofit: Retrofit) : LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Singleton
    @Provides
    fun provideLoginRepository(loginApi: LoginApi) : LoginRepository {
        return LoginRepositoryImpl(loginApi)
    }


}