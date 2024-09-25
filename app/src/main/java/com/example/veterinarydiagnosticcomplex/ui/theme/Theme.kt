package com.example.veterinarydiagnosticcomplex.ui.theme

import android.view.Window
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF3CB9FF),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFFFE614C),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFF8F8F8F),
    surface = Color(0xFFE4F5FF),
    onSurface = Color(0xFF000000),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000)
)

@Composable
fun VeterinaryDiagnosticComplexTheme(
    window: Window,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

    window.statusBarColor = colorScheme.background.toArgb()

    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowInsetsControllerCompat(window, window.decorView).run {
        isAppearanceLightStatusBars = true
    }
}