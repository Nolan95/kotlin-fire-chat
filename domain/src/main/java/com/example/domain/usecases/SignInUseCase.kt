package com.example.domain.usecases

import com.example.domain.entities.UserParams
import com.example.domain.repositories.SignInRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

class SignInUseCase : KoinComponent {
    private val signInRepository: SignInRepository by inject()
    suspend operator fun invoke(userParams: UserParams) =
        signInRepository.signIn(userParams)
}