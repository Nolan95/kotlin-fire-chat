package com.example.datalayer.signup

import com.example.datalayer.UserPayload
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 7/25/20.
 */
interface SignUpDataStore {
    suspend fun signUp(userPayload: UserPayload): Result
}