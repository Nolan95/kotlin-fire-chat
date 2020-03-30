package com.example.kotlinfirechat.data

import java.lang.Exception

/**
 * Created by Sadate Tchamouza on 2020-02-27.
 *
 * This is
 */

sealed class FirebaseAuthState<out T> {
    class Loading<out T>: FirebaseAuthState<T>()
    data class Success<out T>(val user: T) : FirebaseAuthState<T>()
    data class Error<out T>(val exception: Exception) : FirebaseAuthState<T>()
}