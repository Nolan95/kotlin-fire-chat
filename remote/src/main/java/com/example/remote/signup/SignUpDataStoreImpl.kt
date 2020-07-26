package com.example.remote.signup

import com.example.datalayer.FirebaseUserMapper
import com.example.datalayer.UserPayload
import com.example.datalayer.signup.SignUpDataStore
import com.example.domain.utils.Result
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

/**
 * Created by Sadate Tchamouza on 7/25/20.
 */
class SignUpDataStoreImpl(
    private val auth: FirebaseAuth,
    private val firebaseUserMapper: FirebaseUserMapper
) : SignUpDataStore {
    override suspend fun signUp(userPayload: UserPayload): Result {
        return try {
            val response =
                auth.createUserWithEmailAndPassword(userPayload.email, userPayload.password).await()
            Result.Success(response.user)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}