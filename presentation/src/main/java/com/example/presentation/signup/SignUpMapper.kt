package com.example.presentation.signup

import com.example.domain.entities.User
import com.example.presentation.signin.UserUiModel

/**
 * Created by Sadate Tchamouza on 7/25/20.
 */


fun mapUserToUserModel(user: User) = UserUiModel.UserUiModelData(
    fullName = user.name ?: "",
    photoUrl = user.photoUrl
)
