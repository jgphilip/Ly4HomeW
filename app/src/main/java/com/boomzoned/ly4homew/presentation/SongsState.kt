package com.boomzoned.ly4homew.presentation

import com.boomzoned.ly4homew.domain.model.Song

data class SongsState (
    var isLoading : Boolean = true,
    val songs : List<Song> = emptyList()){
}