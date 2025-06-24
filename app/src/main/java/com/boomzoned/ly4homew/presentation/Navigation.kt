package com.boomzoned.ly4homew.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.boomzoned.ly4homew.presentation.screens.Favorites
import com.boomzoned.ly4homew.presentation.screens.HomeScreen
import com.boomzoned.ly4homew.presentation.screens.Settings
import com.boomzoned.ly4homew.presentation.screens.SongDetailScreen
import com.boomzoned.ly4homew.presentation.screens.SongsScreen
import com.boomzoned.ly4homew.presentation.screens.tempScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Favorites.route) {
            Favorites()
        }
        composable(BottomNavItem.Settings.route) {
            Settings()
        }
        composable(BottomNavItem.Songs.route) {
            SongsScreen(navController)
        }

        composable(
            route = Screen.SongDetailScreen.route + "/{songLyrics}",
            arguments = listOf(
                navArgument("songLyrics") {
                    type = NavType.StringType
                    defaultValue = "Lyrics are not available"
                    nullable = true
                }
            )
        ) { entry ->
            entry.arguments?.getString("songLyrics")
                ?.let { lyrics -> SongDetailScreen(song = lyrics) }
        }

        composable(
            route = "temp"
        ) {
            tempScreen()
        }

    }
}