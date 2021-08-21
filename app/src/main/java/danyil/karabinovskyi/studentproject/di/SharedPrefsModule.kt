package danyil.karabinovskyi.studentproject.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import danyil.karabinovskyi.studentproject.utils.SharedPrefs

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefsModule {

    @Provides
    fun provideSharedPref(@ApplicationContext context: Context) : SharedPrefs{
        return SharedPrefs(context)
    }
}