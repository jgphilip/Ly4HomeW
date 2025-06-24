package com.boomzoned.ly4homew.domain.usecases

import com.boomzoned.ly4homew.domain.model.Genre
import com.boomzoned.ly4homew.domain.repository.SongsRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class FetchSongsUseCase(
    private val repository: SongsRepository
) {
    suspend operator fun invoke() = repository.getAllSongs()

}