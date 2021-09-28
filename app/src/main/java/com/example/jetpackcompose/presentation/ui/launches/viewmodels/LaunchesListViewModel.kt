package com.example.jetpackcompose.presentation.ui.launches.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.data.dto.Launch
import com.example.jetpackcompose.data.remote.SpaceXQuery
import com.example.jetpackcompose.interactors.launches.QueryLaunchesUseCase
import com.example.jetpackcompose.presentation.ui.launches.state.LaunchListEvents
import com.example.jetpackcompose.presentation.ui.launches.state.LaunchListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class LaunchesListViewModel
@Inject
constructor(
    private val queryLaunchesUseCase: QueryLaunchesUseCase,
): ViewModel() {

    val state: MutableState<LaunchListState> = mutableStateOf(LaunchListState())

    init {
        onTriggerEvent(LaunchListEvents.LoadLaunches)
    }

    fun onTriggerEvent(event: LaunchListEvents){
        when (event){
            LaunchListEvents.LoadLaunches -> {
                load()
            }
            LaunchListEvents.NextPage -> {
                nextPage()
            }
            else -> {

            }
        }
    }

    /**
     * Get the next page
     */
    private fun nextPage(){
        state.value = state.value.copy(page = state.value.page + 1)
        load()
    }

    private fun load(){

        val query = SpaceXQuery(page = state.value.page)

        queryLaunchesUseCase.execute(query = query).onEach { dataState ->
            state.value = state.value.copy(isLoading = dataState.loading)

            dataState.data?.let { items ->
                append(items.docs)
            }
        }.launchIn(viewModelScope)

    }

    private fun append(items: List<Launch>){
        val curr = ArrayList(state.value.launches)
        curr.addAll(items)
        state.value = state.value.copy(launches = curr)
    }

}