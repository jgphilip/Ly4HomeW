package com.boomzoned.ly4homew.domain.model

import kotlinx.serialization.Serializable

@Serializable
open class Genre {
    private var genreId: Int = 0

    fun getGenreId(): Int {
        return genreId
    }

    constructor(id: Int) {
        this@Genre.genreId = id
    }

}

@Serializable
class HYMN() : Genre(1) {}

@Serializable
class MODERN_WORSHIP() : Genre(2)

@Serializable
class HINDI_CLASSIC() : Genre(3)

@Serializable
class HINDI_MODERN() : Genre(4)

@Serializable
class MALAYALAM_CLASSIC() : Genre(5)

@Serializable
class MALAYALAM_MODERN() : Genre(6)

@Serializable
class ROCK() : Genre(7)
