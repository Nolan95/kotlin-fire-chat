package com.example.presentation.base

import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

interface BaseStore<in R : Result> {
    fun dispatchState(result: R)
}