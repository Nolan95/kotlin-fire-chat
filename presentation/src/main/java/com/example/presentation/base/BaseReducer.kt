package com.example.presentation.base

import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

interface BaseReducer<in R : Result, S : BaseViewState> {
    fun reduce(result: R, state: S?): S

    class UndefinedResultException : Throwable("Undefined Result")
}