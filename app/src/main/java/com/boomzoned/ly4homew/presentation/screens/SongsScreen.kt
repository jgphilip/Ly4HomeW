package com.boomzoned.ly4homew.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material.Surface
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boomzoned.ly4homew.domain.model.Song
import com.boomzoned.ly4homew.data.fetchSongs
import com.boomzoned.ly4homew.presentation.Screen
import com.boomzoned.ly4homew.presentation.theme.secondaryContainerLight
import com.boomzoned.ly4homew.presentation.viewmodel.SongsViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun SongsScreen(
    navController : NavController
    ) {
    Surface {
        DrawSongsScreen(navController)
    }
}


@Composable
fun DrawSongsScreen(
    navController: NavController,
    viewModel: SongsViewModel = hiltViewModel()
    ) {

    val state = viewModel.state.collectAsState()

    when(state.value.isLoading) {
        true -> {
            Text(
                text = "Loading...",
                modifier = Modifier.padding(16.dp)
            )
        }

        false -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    ),
                contentPadding = PaddingValues(8.dp)
            ) {
                println("Songs :::" + state.value.songs)
                items(state.value.songs) { song ->
                    RowItem(navController = navController, song = song)
                }
            }
        }
    }
}

@Composable
fun RowItem(navController: NavController, song: Song) {
    Column(
        modifier = Modifier
            .clickable(
                onClick = {
                    val encoded = Json.encodeToString(song)
                    println("Encoded string : $encoded")
                    navController.navigate(Screen.SongDetailScreen.withArgs(encoded))
                }
            )
            .height(55.dp)
            .fillMaxWidth()
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(5.dp)
        ){
            val colorForBg = MaterialTheme.colorScheme.primaryContainer
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .drawBehind {
                        drawCircle(
                            color = colorForBg,
                            radius = this.size.maxDimension
                        )
                    },
                text = song.songName[0].toString(),
            )

            Text(
                modifier = Modifier
                    .padding(15.dp,6.dp,6.dp,6.dp),
                fontStyle = FontStyle.Normal,
                color = MaterialTheme.colorScheme.surface,
                text = song.songName)
        }
        Divider(
            modifier = Modifier
                .padding(1.dp,2.dp,1.dp,2.dp)
        )
    }
}


@Preview
@Composable
fun SongsScreenPreview() {
    Surface {
        DrawSongsScreen(
            navController = rememberNavController(),
            viewModel = hiltViewModel()
        )
    }
}

