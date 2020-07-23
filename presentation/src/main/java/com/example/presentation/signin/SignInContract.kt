package com.example.presentation.signin

import android.os.Parcelable
import com.example.presentation.base.BaseIntent
import com.example.presentation.base.BaseViewState
import kotlinx.android.parcel.Parcelize

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

sealed class SignInState : BaseViewState {
    object InitialState : SignInState()
    object SignInProgressState : SignInState()
    data class SignInSuccess(val user: UserUiModel.UserUiModelData) : SignInState()
    data class SignInError(val exception: Exception) : SignInState()
}

sealed class SignInIntent : BaseIntent {
    data class SubmitSignInForm(val email: String, val password: String) : SignInIntent()
}

interface UserUiModel {
    @Parcelize
    data class UserUiModelData(
        val fullName: String,
        val photoUrl: String
    ) : Parcelable
}