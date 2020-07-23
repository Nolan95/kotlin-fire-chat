package com.example.remote.signin

import com.example.datalayer.FirebaseUserMapper
import com.example.datalayer.UserPayload
import com.example.datalayer.signin.SignInDataStore
import com.example.domain.utils.Result
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

/**
 * Created by Sadate Tchamouza on 6/17/20.
 */

class SignInDataStoreImpl(
    private val auth: FirebaseAuth,
    private val firebaseUserMapper: FirebaseUserMapper
) : SignInDataStore {
    /*  override suspend fun createUser(userPayload: UserPayload): Result {
          return try {
              val response = auth.createUserWithEmailAndPassword(userPayload.email, userPayload.password).await()
              Result.Success(response.user!!)
          } catch (e: Exception) {
              Result.Error(e)
          }
      }*/

    override suspend fun signIn(userPayload: UserPayload): Result {
        return try {
            val response =
                auth.signInWithEmailAndPassword(userPayload.email, userPayload.password).await()
            Result.Success(firebaseUserMapper.toUser(response.user))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}