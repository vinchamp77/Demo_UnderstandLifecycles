package com.example.understandlifecyclesdemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.understandlifecyclesdemo.ui.screens.HomeScreen
import com.example.understandlifecyclesdemo.ui.screens.SecondScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.Login.path
    ) {
        addFirstScreen(navController, this)

        addSecondScreen(navController, this)
    }
}

private fun addFirstScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        SecondScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addSecondScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {

        HomeScreen(
            popBackStack = { navController.popBackStack() },
        )
    }
}
