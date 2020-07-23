package com.example.domain

import com.example.domain.usecases.SignInUseCase
import org.koin.dsl.module

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

val domainModule = module {
    factory { SignInUseCase() }
}