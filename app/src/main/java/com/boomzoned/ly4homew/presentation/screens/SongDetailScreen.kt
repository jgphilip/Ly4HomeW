package com.boomzoned.ly4homew.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boomzoned.ly4homew.domain.model.Song
import com.boomzoned.ly4homew.presentation.layoutstest.TypesOfRows
import kotlinx.serialization.json.Json

@Composable
fun SongDetailScreen(
    song: String,
) {
    val songObj = Json.decodeFromString<Song>(song)
    mainUI(lyricsMap = songObj.songLyrics)
}

@Composable
fun mainUI(lyricsMap: String){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier
                .padding(10.dp),
            color = MaterialTheme.colorScheme.surface,
            text = lyricsMap,
        )
    }
}

@Composable
fun tempScreen(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF005AA7),
                        Color(0xFFFFFDE4)
                    )
                )
            )
    ) {
        Column {
            Text(text = "Text 1")
            Text(text = "Text 1")
            Text(text = "Text 1")
        }
        Row {
            Text(text = "Text 2")
            Text(text = "Text 1")
            Text(text = "Text 1")
        }
    }
}

@Preview
@Composable
fun prevTemp(){
    tempScreen()
}