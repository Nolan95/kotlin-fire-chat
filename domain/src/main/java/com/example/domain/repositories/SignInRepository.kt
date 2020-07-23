package com.example.domain.repositories

import com.example.domain.entities.UserParams
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

interface SignInRepository {
    suspend fun signIn(userParams: UserParams): Result
}