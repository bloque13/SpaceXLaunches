package com.example.jetpackcompose.presentation.ui.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.presentation.navigation.Screen
import com.example.jetpackcompose.presentation.theme.AppTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun DashboardScreen(
    onNavigateToScreen: (String) -> Unit,
    viewModel: DashboardViewModel,
) {

    val scaffoldState = rememberScaffoldState()

    AppTheme(
        displayProgressBar = false,
//        scaffoldState = scaffoldState,
        darkTheme = false
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Dashboard",
                            color = Color.Black
                        )
                    },
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary,
                    elevation = 12.dp
                )
            },
            content = {
                Column {

                    DashboardItemView(
                        link = "Demo Bad Loading",
                        title = "View Launches",
                        onNavigateToScreen = onNavigateToScreen,
                        route = Screen.Launches.route
                    )
                    DashboardItemView(
                        link = "Demo Loading",
                        title = "View Launches With Pagination",
                        onNavigateToScreen = onNavigateToScreen,
                        route = Screen.LaunchesWithPagination.route
                    )
                }

            }
        )
    }
}