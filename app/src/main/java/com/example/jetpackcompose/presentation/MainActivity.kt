package com.example.jetpackcompose.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.presentation.navigation.Screen
import com.example.jetpackcompose.presentation.ui.dashboard.DashboardScreen
import com.example.jetpackcompose.presentation.ui.dashboard.DashboardViewModel
import com.example.jetpackcompose.presentation.ui.launches.screens.LaunchListScreen
import com.example.jetpackcompose.presentation.ui.launches.screens.LaunchScreen
import com.example.jetpackcompose.presentation.ui.launches.viewmodels.LaunchesViewModel
import com.example.jetpackcompose.presentation.ui.launches.viewmodels.LaunchesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    var currentScreen: String = ""
    var navController: NavHostController? = null
    lateinit var dashBoardiewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()

            navController?.let { navController ->

                navController.addOnDestinationChangedListener(this)

                NavHost(navController = navController, startDestination = Screen.Dashboard.route) {

                    composable(route = Screen.Dashboard.route) { navBackStackEntry ->
                        dashBoardiewModel =
                            hiltNavGraphViewModel<DashboardViewModel>(navBackStackEntry)
                        DashboardScreen(
                            viewModel = dashBoardiewModel,
                            onNavigateToScreen = { route ->
                                navController.navigate(route)
                            }
                        )
                    }

                    composable(route = Screen.Launches.route) {
                        LaunchScreen(
                            viewModel = hiltNavGraphViewModel<LaunchesViewModel>(it),
                            )
                    }

                    composable(route = Screen.LaunchesWithPagination.route) { navBackStackEntry ->
                        val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                        val viewModel: LaunchesListViewModel = viewModel("LaunchesListViewModel", factory)
                        LaunchListScreen(
                            state = viewModel.state.value,
                            onTriggerEvent = viewModel::onTriggerEvent,
                        )
                    }
                }
            }

        }
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        val destination =
            destination.arguments["android-support-nav:controller:route"]?.defaultValue.toString()
        if (
            (currentScreen == Screen.Launches.route ||
                    currentScreen == Screen.LaunchesWithPagination.route)
            && destination == Screen.Dashboard.route) {
            dashBoardiewModel.reload()
        }
        currentScreen = destination

    }
}
