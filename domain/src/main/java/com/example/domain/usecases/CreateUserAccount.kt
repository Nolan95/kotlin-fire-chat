package com.example.domain.usecases

import com.example.domain.entities.User
import com.example.domain.repositories.UserRepository
import com.example.domain.utils.Result
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

class CreateUserAccount : KoinComponent {
    private val userRepository: UserRepository by inject()
    suspend operator fun invoke(email: String, password: String): Result<User> =
        userRepository.createUser(email, password)
}