package com.sunasterisk.loltournaments.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

class BaseViewModel : ViewModel() {
    protected val _error = MutableLiveData<String>()
    val error get() = _error

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.postValue(throwable.message)
    }
}
