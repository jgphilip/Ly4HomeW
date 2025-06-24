package com.boomzoned.ly4homew.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.boomzoned.ly4homew.R

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = stringResource(id = R.string.wip),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .align(AbsoluteAlignment.CenterRight)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}