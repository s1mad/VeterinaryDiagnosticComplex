package com.example.veterinarydiagnosticcomplex.presentation.component.bottom_bar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.veterinarydiagnosticcomplex.presentation.component.bottom_bar.model.BottomBar

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBar.Pet,
        BottomBar.Details,
        BottomBar.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    if (screens.any{ currentDestination?.route == it.route}) {
        NavigationBar(
            modifier = Modifier
                .height(96.dp)
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            screens.forEach { screen ->
                AddNavigationBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                )
            }
        }
    }
}