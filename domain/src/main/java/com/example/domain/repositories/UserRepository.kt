package com.example.domain.repositories

import com.example.domain.entities.User
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

interface UserRepository {
    suspend fun createUser(email: String, password: String) : Result<User>
    suspend fun logUser(email: String, password: String) : Result<User>
}