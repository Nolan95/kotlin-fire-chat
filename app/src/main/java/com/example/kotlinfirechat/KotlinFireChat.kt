package com.example.kotlinfirechat

import android.app.Application
import com.example.preferences.SessionModelImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * Created by Sadate Tchamouza on 3/27/20.
 */
@ExperimentalCoroutinesApi
@FlowPreview
class KotlinFireChat : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@KotlinFireChat)
            modules(appDiModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        SessionModelImpl.init(this)
    }
}