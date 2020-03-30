package com.example.domain.entities

/**
 * Created by Sadate Tchamouza on 3/18/20.
 */

data class User(val name: String? = "",
                val email: String = "",
                val photoUrl: String = "",
                val uid: String = "",
                val isEmailVerified: Boolean)