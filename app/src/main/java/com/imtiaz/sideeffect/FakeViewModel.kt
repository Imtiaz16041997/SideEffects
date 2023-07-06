package com.imtiaz.sideeffect

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FakeViewModel: ViewModel(){

    val state: MutableState<ResultType> = mutableStateOf(ResultType.Idle)

    fun getData() = viewModelScope.launch {
        state.value = ResultType.Loading
        delay(3000)
        state.value = ResultType.Success
    }
}