package com.example.datalayer

import com.example.domain.entities.User
import com.google.firebase.auth.FirebaseUser

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

class FirebaseUserMapper {

    fun toUser(firebaseUser: FirebaseUser?): User {
        return User(
            email = firebaseUser?.email!!,
            photoUrl = firebaseUser.photoUrl.toString(),
            name = firebaseUser.displayName ?: "",
            uid = firebaseUser.uid
        )
    }
}