package com.example.presentation.signin

import com.example.domain.entities.User
import com.example.domain.utils.Result
import com.example.presentation.base.BaseReducer

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */


class SignInReducer : BaseReducer<Result, SignInState> {
    override fun reduce(result: Result, state: SignInState?): SignInState {
        return when (result) {
            is Result.Loading -> SignInState.SignInProgressState
            is Result.Success<*> -> SignInState.SignInSuccess(mapUserToUserModel(result.user as User))
            is Result.Error -> SignInState.SignInError(result.exception)
            else -> throw BaseReducer.UndefinedResultException()
        }
    }

    companion object {
        val name = SignInReducer::class.java.name
    }
}