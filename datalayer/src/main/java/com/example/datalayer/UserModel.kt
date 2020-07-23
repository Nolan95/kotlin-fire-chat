package com.example.datalayer

import com.example.domain.entities.UserParams

/**
 * Created by Sadate Tchamouza on 6/17/20.
 */

data class UserPayload(val email: String, val password: String)
class UserPayloadMapper {
    fun toUserPayload(userParams: UserParams) =
        UserPayload(
            email = userParams.email,
            password = userParams.password
        )
}