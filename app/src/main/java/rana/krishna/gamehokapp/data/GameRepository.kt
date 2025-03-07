package rana.krishna.gamehokapp.data

import javax.inject.Inject

class GameRepository @Inject constructor(private val api: GameApi){
    suspend fun getGames() = api.getGames()
    suspend fun getTournaments() = api.getTournaments()
}