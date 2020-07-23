package com.example.domain.repositories

import com.example.domain.entities.UserParams
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */
interface SignUpRepository {
    suspend fun signUp(userParams: UserParams): Result

}