package com.example.presentation.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.UserParams
import com.example.domain.usecases.SignInUseCase
import com.example.domain.utils.Result
import com.example.presentation.base.BaseViewModel
import com.example.presentation.base.Store
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */
@FlowPreview
@ExperimentalCoroutinesApi
class SignInViewModel(
    private val store: Store<Result, SignInState>,
    private val signInUseCase: SignInUseCase
) : ViewModel(), BaseViewModel<SignInIntent, SignInState> {

    lateinit var signInParams: UserParams

    private val _intentChannel = BroadcastChannel<SignInIntent>(capacity = Channel.CONFLATED)

    override suspend fun processIntents(intent: SignInIntent) = _intentChannel.send(intent)

    override fun states(): LiveData<out SignInState> = store.viewState

    init {
        _intentChannel
            .asFlow()
            .getResult()
            .launchIn(viewModelScope)
    }

    private fun Flow<SignInIntent>.getResult() = onEach {
        when (it) {
            is SignInIntent.SubmitSignInForm -> signIn(it.email, it.password)
        }
    }

    private fun signIn(email: String, password: String) {
        signInParams = UserParams(email = email, password = password)

        flow {
            this.emit(signInUseCase(signInParams))
        }.onStart { this.emit(Result.Loading) }
            .onEach { store.dispatchState(it) }
            .launchIn(viewModelScope)
    }

}
