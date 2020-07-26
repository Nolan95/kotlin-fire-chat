package com.example.presentation.signup

import com.example.domain.entities.User
import com.example.domain.utils.Result
import com.example.presentation.base.BaseReducer

/**
 * Created by Sadate Tchamouza on 7/25/20.
 */


class SignUpReducer : BaseReducer<Result, SignUpState> {
    override fun reduce(result: Result, state: SignUpState?): SignUpState {
        return when (result) {
            is Result.Loading -> SignUpState.SignUpProgressState
            is Result.Success<*> -> SignUpState.SignUpSuccess(mapUserToUserModel(result.user as User))
            is Result.Error -> SignUpState.SignUpError(result.exception)
            else -> throw BaseReducer.UndefinedResultException()
        }
    }

    companion object {
        val name = SignUpReducer::class.java.name
    }
}