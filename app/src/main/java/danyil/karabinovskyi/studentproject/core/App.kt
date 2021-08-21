package danyil.karabinovskyi.studentproject.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import danyil.karabinovskyi.studentproject.BuildConfig


@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}