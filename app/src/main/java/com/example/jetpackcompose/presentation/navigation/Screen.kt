package com.example.jetpackcompose.presentation.navigation

sealed class Screen(
    val route: String,
) {
    object Dashboard: Screen("dashboard")

    object Launches : Screen("launches")

    object LaunchesWithPagination : Screen("launches-with-pagination")

}
