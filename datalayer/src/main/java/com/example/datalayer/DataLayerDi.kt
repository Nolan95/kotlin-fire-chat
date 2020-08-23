package com.example.datalayer

import com.example.datalayer.signin.SignInRepositoryImpl
import com.example.datalayer.signup.SignUpRepositoryImpl
import com.example.domain.repositories.SignInRepository
import com.example.domain.repositories.SignUpRepository
import org.koin.dsl.module

/**
 * Created by Sadate Tchamouza on 6/17/20.
 */

val dataModule = module {
    factory { UserPayloadMapper() }
    factory { FirebaseUserMapper() }
    factory<SignInRepository> { SignInRepositoryImpl(get(), get()) }
    factory<SignUpRepository> { SignUpRepositoryImpl(get(), get()) }
}
