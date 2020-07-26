package com.example.presentation.signup

import com.example.presentation.base.BaseIntent
import com.example.presentation.base.BaseViewState
import com.example.presentation.signin.UserUiModel

/**
 * Created by Sadate Tchamouza on 7/25/20.
 */

sealed class SignUpState : BaseViewState {
    object InitialState : SignUpState()
    object SignUpProgressState : SignUpState()
    data class SignUpSuccess(val user: UserUiModel.UserUiModelData) : SignUpState()
    data class SignUpError(val exception: Exception) : SignUpState()
}

sealed class SignUpIntent : BaseIntent {
    data class SubmitSignUpForm(val email: String, val password: String) : SignUpIntent()
}
