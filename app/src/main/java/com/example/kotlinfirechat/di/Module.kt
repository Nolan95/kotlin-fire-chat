package com.example.kotlinfirechat.di

import com.example.domain.repositories.UserRepository
import com.example.domain.usecases.CreateUserAccount
import com.example.domain.usecases.LogUser
import com.example.kotlinfirechat.data.repositories.UserRepositoryImpl
import com.example.kotlinfirechat.viewmodels.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Sadate Tchamouza on 3/23/20.
 */

val viewModelModule  = module {
    viewModel { LoginViewModel(get(), get()) }
}


val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
}

val useCasesModule = module {
    single { CreateUserAccount() }
    single { LogUser() }
}

val firebaseModule = module {
    single { FirebaseAuth.getInstance() }
}