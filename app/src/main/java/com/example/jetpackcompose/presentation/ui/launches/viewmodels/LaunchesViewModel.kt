package com.example.jetpackcompose.presentation.ui.launches.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.interactors.launches.GetLaunchesUseCase
import com.example.jetpackcompose.presentation.ui.launches.state.LaunchListEvents
import com.example.jetpackcompose.presentation.ui.launches.state.LaunchListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(
    private val getLaunchesUseCase: GetLaunchesUseCase,

    ) : ViewModel() {

    val state: MutableState<LaunchListState> = mutableStateOf(LaunchListState())

    init {
        onTriggerEvent(LaunchListEvents.LoadLaunches)
    }

    private fun onTriggerEvent(event: LaunchListEvents.LoadLaunches) {
        when (event) {
            LaunchListEvents.LoadLaunches -> {
                loadLaunches()
            }
        }
    }

    fun loadLaunches() {
        getLaunchesUseCase.execute().onEach { dataState ->
            state.value = state.value.copy(isLoading = dataState.loading)

            dataState.data?.let {
                state.value = state.value.copy(launches = it)
            }

        }.launchIn(viewModelScope)
    }

}