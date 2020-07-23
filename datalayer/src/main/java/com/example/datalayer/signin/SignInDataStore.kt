package com.example.datalayer.signin

import com.example.datalayer.UserPayload
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 6/17/20.
 */
interface SignInDataStore {
    suspend fun signIn(userPayload: UserPayload): Result
}