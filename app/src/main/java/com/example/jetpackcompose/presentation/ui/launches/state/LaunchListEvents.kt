package com.example.jetpackcompose.presentation.ui.launches.state

sealed class LaunchListEvents {

    object LoadLaunches: LaunchListEvents()

    object NextPage: LaunchListEvents()

}