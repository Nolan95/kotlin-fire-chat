package com.example.presentation.signin

import com.example.domain.entities.User

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

fun mapUserToUserModel(user: User) = UserUiModel.UserUiModelData(
    fullName = user.name ?: "",
    photoUrl = user.photoUrl
)
