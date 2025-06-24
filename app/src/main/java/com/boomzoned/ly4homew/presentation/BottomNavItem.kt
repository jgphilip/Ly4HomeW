package com.boomzoned.ly4homew.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    data object Songs : BottomNavItem("songs", Icons.Default.PlayArrow, "Songs")
    data object Favorites : BottomNavItem("favorites", Icons.Default.Favorite, "Favorites")
    data object Settings : BottomNavItem("settings", Icons.Default.Settings, "Settings")
}

sealed class Screen(val route : String) {
    data object SongDetailScreen : Screen("song_detail_screen")
    fun withArgs(vararg args : String) : String {
        return buildString {
            append(route)
            args.forEach {
                arg -> append("/$arg")
            }
        }
    }
}