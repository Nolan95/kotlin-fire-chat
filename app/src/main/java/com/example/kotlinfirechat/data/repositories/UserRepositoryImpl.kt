package com.example.kotlinfirechat.data.repositories

import com.example.domain.entities.User
import com.example.domain.repositories.UserRepository
import com.example.domain.utils.Result
import com.example.kotlinfirechat.data.FirebaseUserMapper
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import java.lang.Exception

/**
 * Created by Sadate Tchamouza on 3/27/20.
 */
class UserRepositoryImpl(private val auth: FirebaseAuth) : UserRepository {

    override suspend fun createUser(email: String, password: String): Result<User> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            Result.Success(FirebaseUserMapper.toUser(result.user))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun logUser(email: String, password: String): Result<User> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Result.Success(FirebaseUserMapper.toUser(result.user))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }


}