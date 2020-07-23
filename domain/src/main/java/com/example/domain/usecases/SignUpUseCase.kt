package com.example.domain.usecases

import com.example.domain.entities.UserParams
import com.example.domain.repositories.SignUpRepository
import com.example.domain.utils.Result
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

class SignUpUseCase : KoinComponent {
    private val signUpRepository: SignUpRepository by inject()
    suspend operator fun invoke(userParams: UserParams): Result =
        signUpRepository.signUp(userParams)
}