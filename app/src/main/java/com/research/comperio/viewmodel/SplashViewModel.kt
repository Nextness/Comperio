package com.research.comperio.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.research.comperio.data.DataStoreRepository
import com.research.comperio.structures.ScreenHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
): ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(ScreenHolder.OnboardingScreenHolder.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnboardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = ScreenHolder.HomeScreenHolder.route
                } else {
                    _startDestination.value = ScreenHolder.OnboardingScreenHolder.route
                }
            }
            _isLoading.value = false
        }
    }
}
