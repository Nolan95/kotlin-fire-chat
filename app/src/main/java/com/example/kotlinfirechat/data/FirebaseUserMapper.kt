package com.example.kotlinfirechat.data

import com.example.domain.entities.User
import com.google.firebase.auth.FirebaseUser

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

object FirebaseUserMapper {

    fun toUser(firebaseUser: FirebaseUser?): User {
        return User(
                email = firebaseUser?.email!!,
                photoUrl = firebaseUser.photoUrl.toString(),
                name = firebaseUser.displayName ?: "",
                isEmailVerified = firebaseUser.isEmailVerified,
                uid = firebaseUser.uid)

    }
}