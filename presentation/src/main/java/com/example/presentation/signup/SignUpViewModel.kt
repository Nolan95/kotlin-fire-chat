package com.example.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.UserParams
import com.example.domain.usecases.SignUpUseCase
import com.example.domain.utils.Result
import com.example.presentation.base.BaseViewModel
import com.example.presentation.base.Store
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

/**
 * Created by Sadate Tchamouza on 7/25/20.
 */

@FlowPreview
@ExperimentalCoroutinesApi
class SignUpViewModel(
    private val store: Store<Result, SignUpState>,
    private val signUpUseCase: SignUpUseCase
) : ViewModel(), BaseViewModel<SignUpIntent, SignUpState> {

    private lateinit var signUpParams: UserParams

    private val _intentChannel = BroadcastChannel<SignUpIntent>(capacity = Channel.CONFLATED)


    override suspend fun processIntents(intent: SignUpIntent) = _intentChannel.send(intent)

    override fun states(): LiveData<out SignUpState> = store.viewState

    init {
        _intentChannel
            .asFlow()
            .getResult()
            .launchIn(viewModelScope)
    }

    private fun Flow<SignUpIntent>.getResult() = onEach {
        when (it) {
            is SignUpIntent.SubmitSignUpForm -> signUp(it.email, it.password)
        }
    }

    private fun signUp(email: String, password: String) {
        signUpParams = UserParams(email = email, password = password)

        flow {
            this.emit(signUpUseCase(signUpParams))
        }.onStart { this.emit(Result.Loading) }
            .onEach { store.dispatchState(it) }
            .launchIn(viewModelScope)
    }
}