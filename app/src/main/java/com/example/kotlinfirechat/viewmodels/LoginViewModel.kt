package com.example.kotlinfirechat.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.User
import com.example.domain.usecases.CreateUserAccount
import com.example.domain.usecases.LogUser
import com.example.domain.utils.Result
import com.example.kotlinfirechat.data.FirebaseAuthStateManager
import kotlinx.coroutines.launch

/**
 * Created by Sadate Tchamouza on 2/27/20.
 */

class LoginViewModel(val createUserAccount: CreateUserAccount,
                     val logUser: LogUser) : ViewModel() {

    private var firebaseLoginStateManager = FirebaseAuthStateManager<User>()

    fun firebaseCreateAccount(email: String, password: String): FirebaseAuthStateManager<User> {
        viewModelScope.launch {
            when(val result = createUserAccount(email, password)) {
                is Result.Success -> {
                    firebaseLoginStateManager.success(result.user)
                }
                is Result.Error -> {
                    firebaseLoginStateManager.error(result.exception)
                }
            }
        }
        return firebaseLoginStateManager
    }

    fun firebaseLogin(email: String, password: String): FirebaseAuthStateManager<User> {
        viewModelScope.launch {
            when(val result = logUser(email, password)) {
                is Result.Success -> {
                    firebaseLoginStateManager.success(result.user)
                }
                is Result.Error -> {
                    firebaseLoginStateManager.error(result.exception)
                }
            }
        }
        return firebaseLoginStateManager
    }

}