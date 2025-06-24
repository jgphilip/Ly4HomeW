package com.boomzoned.ly4homew.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Song(
    @SerializedName("hymn_title") val songName: String,
    val songGenre: Genre? ,
    val tags: List<SongTag> ?,
    @SerializedName("hymn") val songLyrics: String
)
