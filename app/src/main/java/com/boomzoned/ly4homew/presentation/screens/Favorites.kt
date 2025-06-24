package com.boomzoned.ly4homew.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Favorites() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "Favorites"
        )
    }
}