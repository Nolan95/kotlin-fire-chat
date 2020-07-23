package com.example.datalayer

import androidx.lifecycle.LiveData

/**
 * Created by Sadate Tchamouza on 2/27/20.
 */

class FirebaseAuthStateManager<T> : LiveData<FirebaseAuthState<T>>() {
    init {
        value = FirebaseAuthState.Loading()
    }

    fun success(data: T) {
        postValue(FirebaseAuthState.Success(data))
    }

    fun error(error: Exception) {
        postValue(FirebaseAuthState.Error(error))
    }
}