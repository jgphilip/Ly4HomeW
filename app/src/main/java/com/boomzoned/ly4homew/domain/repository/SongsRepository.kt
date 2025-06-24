package com.boomzoned.ly4homew.domain.repository

import com.boomzoned.ly4homew.domain.model.Song
import kotlinx.coroutines.flow.Flow

interface SongsRepository {
    suspend fun getAllSongs() : List<Song>
}