package com.example.datalayer.signin

import com.example.datalayer.UserPayloadMapper
import com.example.domain.entities.UserParams
import com.example.domain.repositories.SignInRepository
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 3/27/20.
 */
class SignInRepositoryImpl(
    private val signInDataStore: SignInDataStore,
    private val userPayloadMapper: UserPayloadMapper
) : SignInRepository {


    override suspend fun signIn(userParams: UserParams): Result {
        return signInDataStore.signIn(userPayloadMapper.toUserPayload(userParams))
    }

}