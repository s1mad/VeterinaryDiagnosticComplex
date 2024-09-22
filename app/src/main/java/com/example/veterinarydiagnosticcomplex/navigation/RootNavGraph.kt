package com.example.veterinarydiagnosticcomplex.navigation


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.veterinarydiagnosticcomplex.presentation.screen.auth.AuthScreen
import com.example.veterinarydiagnosticcomplex.presentation.screen.pet.PetScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Auth.route,
        route = ROOT_GRAPH_ROUTE
    ) {
        composable(route = Screen.Auth.route) {
            AuthScreen(modifier, navController = navController)
        }
        composable(route = Screen.Pet.route) {
            PetScreen(modifier)
        }
        composable(route = Screen.Details.route) {
            Text(modifier = modifier, text = "Details")
        }
        composable(route = Screen.Settings.route) {
            Text(modifier = modifier, text = "Settings")
        }
    }
}
