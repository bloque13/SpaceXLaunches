package com.example.jetpackcompose.presentation.ui.launches.state

import com.example.jetpackcompose.data.dto.Launch

data class LaunchListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val error: String = "",
    val launches: List<Launch> = listOf(),
    )