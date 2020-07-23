package com.example.presentation.base

import androidx.lifecycle.LiveData

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

interface BaseViewModel<in I : BaseIntent, out S : BaseViewState> {
    suspend fun processIntents(intent: I)

    fun states(): LiveData<out S>
}