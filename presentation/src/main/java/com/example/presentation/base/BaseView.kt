package com.example.presentation.base

import kotlinx.coroutines.flow.Flow


/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

interface BaseView<in S : BaseViewState, out I : BaseIntent> {
    fun render(state: S)
    fun intents(): Flow<I>
}