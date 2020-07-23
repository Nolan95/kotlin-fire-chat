package com.example.domain.utils

/**
 * Created by Sadate Tchamouza on 3/23/20.
 */

sealed class Result {
    object Loading : Result()
    data class Success<out T>(val user: T) : Result()
    data class Error(val exception: Exception) : Result()
}