package com.boomzoned.ly4homew.data.repository

import android.content.Context
import com.boomzoned.ly4homew.R
import com.boomzoned.ly4homew.domain.model.Song
import com.boomzoned.ly4homew.domain.repository.SongsRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SongsRepositoryImpl @Inject constructor(
    private val context: Context
) : SongsRepository {
    override suspend fun getAllSongs():List<Song> {
        var hymns = listOf<Song>()
        withContext(Dispatchers.Default) {
            val jsonString =
                context.resources.openRawResource(R.raw.hymns).bufferedReader().use { it.readText() }

            // Parse the JSON string into a list of Hymn objects
             hymns = Gson().fromJson(jsonString, Array<Song>::class.java).toList()

        }
        return hymns
    }
}