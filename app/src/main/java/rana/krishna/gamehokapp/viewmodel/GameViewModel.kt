package rana.krishna.gamehokapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import rana.krishna.gamehokapp.data.GameRepository
import rana.krishna.gamehokapp.model.GameItem
import rana.krishna.gamehokapp.model.TournamentItem

@HiltViewModel
class GameViewModel @Inject constructor(private val repository: GameRepository) : ViewModel() {

    private val _games = MutableStateFlow<List<GameItem>>(emptyList())
    val games: StateFlow<List<GameItem>> get() = _games

    private val _tournaments = MutableStateFlow<List<TournamentItem>>(emptyList())
    val tournaments: StateFlow<List<TournamentItem>> get() = _tournaments

    init {
        fetchGames()
        fetchTournaments()
    }

    private fun fetchGames() {
        viewModelScope.launch {
            try {
                _games.value = repository.getGames()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun fetchTournaments() {
        viewModelScope.launch {
            try {
                _tournaments.value = repository.getTournaments()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}