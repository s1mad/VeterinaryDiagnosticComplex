package com.example.veterinarydiagnosticcomplex.presentation.component.bottom_bar.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Healing
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.veterinarydiagnosticcomplex.navigation.Screen

sealed class BottomBar(
    val route: String,
    val icon: ImageVector
) {
    data object Pet : BottomBar(
        route = Screen.Pet.route,
        icon = Icons.Rounded.Pets
    )

    data object Details : BottomBar(
        route = Screen.Details.route,
        icon = Icons.Rounded.Healing
    )

    data object Settings : BottomBar(
        route = Screen.Settings.route,
        icon = Icons.Rounded.Settings
    )
}