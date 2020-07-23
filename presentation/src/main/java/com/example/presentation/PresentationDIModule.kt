package com.example.presentation

import com.example.presentation.base.Store
import com.example.presentation.signin.SignInReducer
import com.example.presentation.signin.SignInState
import com.example.presentation.signin.SignInViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

@ExperimentalCoroutinesApi
@FlowPreview
val presentationModule = module {

    viewModel {
        SignInViewModel(
            Store(
                get<SignInReducer>(named(SignInReducer.name)),
                SignInState.InitialState
            ), get()
        )
    }
    factory(named(SignInReducer.name)) { SignInReducer() }
}