package com.example.datalayer.signup

import com.example.datalayer.UserPayloadMapper
import com.example.domain.entities.UserParams
import com.example.domain.repositories.SignUpRepository
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 7/25/20.
 */
class SignUpRepositoryImpl(
    private val signUpDataStore: SignUpDataStore,
    private val userPayloadMapper: UserPayloadMapper
) : SignUpRepository {
    override suspend fun signUp(userParams: UserParams): Result {
        return signUpDataStore.signUp(userPayloadMapper.toUserPayload(userParams))
    }
}