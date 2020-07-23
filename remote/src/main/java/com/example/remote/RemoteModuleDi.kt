package com.example.remote

import com.example.datalayer.signin.SignInDataStore
import com.example.remote.signin.SignInDataStoreImpl
import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

/**
 * Created by Sadate Tchamouza on 6/17/20.
 */

val remoteModule = module {
    single { FirebaseAuth.getInstance() }
    factory<SignInDataStore> { SignInDataStoreImpl(get(), get()) }
}