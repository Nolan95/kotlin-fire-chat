package com.example.kotlinfirechat

import android.app.Application
import com.example.kotlinfirechat.di.firebaseModule
import com.example.kotlinfirechat.di.repositoryModule
import com.example.kotlinfirechat.di.useCasesModule
import com.example.kotlinfirechat.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * Created by Sadate Tchamouza on 3/27/20.
 */

class KotlinFireChat : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@KotlinFireChat)
            modules(listOf(repositoryModule, viewModelModule, useCasesModule, firebaseModule))
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}