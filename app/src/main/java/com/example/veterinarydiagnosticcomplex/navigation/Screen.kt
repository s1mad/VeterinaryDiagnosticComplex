package com.example.veterinarydiagnosticcomplex.navigation

const val ROOT_GRAPH_ROUTE = "root_graph"

sealed class Screen(val route: String) {
    data object Auth : Screen(route = "auth")
    data object Pet : Screen(route = "pet")
    data object Details : Screen(route = "details")
    data object Settings : Screen(route = "settings")
}