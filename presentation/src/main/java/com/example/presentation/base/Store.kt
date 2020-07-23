package com.example.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import com.example.domain.utils.Result

/**
 * Created by Sadate Tchamouza on 7/21/20.
 */

class Store<in R : Result, out S : BaseViewState>(
    private val reducer: BaseReducer<R, S>,
    private val initialState: S
) : BaseStore<R> {

    private val _viewState = MutableLiveData<S>().apply { value = initialState }
    val viewState: LiveData<out S> = _viewState.distinctUntilChanged()

    override fun dispatchState(result: R) {
        val state = reducer.reduce(result, viewState.value)
        _viewState.postValue(state)
    }
}