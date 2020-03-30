package com.example.domain.usecases

import com.example.domain.repositories.UserRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

class LogUser : KoinComponent{
    private val userRepository: UserRepository by inject()
    suspend operator fun invoke(email: String, password: String) =
        userRepository.logUser(email, password)

}