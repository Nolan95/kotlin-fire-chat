package com.example.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.domain.entities.User
import com.example.preferences.SessionConst.ACCESS_TOKEN
import com.example.preferences.SessionConst.EMAIL
import com.example.preferences.SessionConst.FULL_NAME_KEY
import com.example.preferences.SessionConst.LOGIN_STATUS
import com.example.preferences.SessionConst.PHONE_NUMBER
import com.example.preferences.SessionConst.PHOTO_URL

/**
 * Created by Sadate Tchamouza on 8/15/20.
 */


interface SessionModel {
    var fullName: String
    var phoneNumber: String
    var email: String
    var photoUrl: String
    var loginStatus: Boolean
    var accessToken: String
}

object SessionModelImpl : SessionModel {
    private val fileName = "SESSION_FILE"
    private lateinit var mPrefs: SharedPreferences

    fun init(context: Context) {
        mPrefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    private fun write() = mPrefs.edit()
    private fun read() = mPrefs

    override var fullName: String
        get() = read().getString(FULL_NAME_KEY, "") ?: ""
        set(value) {
            write().putString(FULL_NAME_KEY, value).apply()
        }

    override var phoneNumber: String
        get() = read().getString(PHONE_NUMBER, "") ?: ""
        set(value) {
            write().putString(PHONE_NUMBER, value).apply()
        }

    override var email: String
        get() = read().getString(EMAIL, "") ?: ""
        set(value) {
            write().putString(EMAIL, value).apply()
        }

    override var photoUrl: String
        get() = read().getString(PHOTO_URL, "") ?: ""
        set(value) {
            write().putString(PHOTO_URL, value).apply()
        }

    override var loginStatus: Boolean
        get() = read().getBoolean(LOGIN_STATUS, false)
        set(value) {
            write().putBoolean(LOGIN_STATUS, value).apply()
        }

    override var accessToken: String
        get() = read().getString(ACCESS_TOKEN, "") ?: ""
        set(value) {
            write().putString(ACCESS_TOKEN, value).apply()
        }


    fun saveUserData(user: User) {
        this.apply {
            fullName = user.name ?: ""
            email = user.email
            photoUrl = user.photoUrl
        }
    }
}


object SessionConst {
    const val FULL_NAME_KEY = "FULL_NAME"
    const val PHONE_NUMBER = "PHONE_NUMBER"
    const val LOGIN_STATUS = "LOGIN_STATUS"
    const val ACCESS_TOKEN = "ACCESS_TOKEN"
    const val EMAIL = "EMAIL"
    const val PHOTO_URL = "PHOTO_URL"
}