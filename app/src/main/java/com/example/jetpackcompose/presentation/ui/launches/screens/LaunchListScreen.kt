package com.example.jetpackcompose.presentation.ui.launches.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.jetpackcompose.presentation.theme.AppTheme
import com.example.jetpackcompose.presentation.ui.launches.component.LaunchList
import com.example.jetpackcompose.presentation.ui.launches.state.LaunchListEvents
import com.example.jetpackcompose.presentation.ui.launches.state.LaunchListState

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun LaunchListScreen(
    state: LaunchListState,
    onTriggerEvent: (LaunchListEvents) -> Unit,
) {
    AppTheme(
        darkTheme = false,
        displayProgressBar = state.isLoading,
    ) {
        Scaffold(
            topBar = {
                Text("Falcon 9 Launches")
            },
        ) {
            LaunchList(
                loading = state.isLoading,
                launches = state.launches,
                page = state.page,
                onTriggerNextPage = {
                    onTriggerEvent(LaunchListEvents.NextPage)
                }
            )
        }
    }
}