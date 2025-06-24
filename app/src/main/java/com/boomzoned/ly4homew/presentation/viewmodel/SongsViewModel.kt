package com.boomzoned.ly4homew.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boomzoned.ly4homew.domain.usecases.FetchSongsUseCase
import com.boomzoned.ly4homew.presentation.SongsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongsViewModel @Inject constructor(
    val useCase: FetchSongsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(SongsState())
    val state: StateFlow<SongsState> = _state

    init {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            useCase().all {  songs  ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        songs = songs
                    )
                }
            }
        }
    }
}