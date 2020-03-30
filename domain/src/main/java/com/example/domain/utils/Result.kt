package com.example.domain.utils

import java.lang.Exception

/**
 * Created by Sadate Tchamouza on 3/23/20.
 */

sealed class Result<out T> {
    data class Success<out T>(val user: T) : Result<T>()
    data class Error<out T>(val exception: Exception) : Result<T>()
}