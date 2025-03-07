package rana.krishna.gamehokapp.data

import rana.krishna.gamehokapp.model.GameItem
import rana.krishna.gamehokapp.model.TournamentItem
import retrofit2.http.GET

interface GameApi {
    @GET("games")
    suspend fun getGames(): List<GameItem>

    @GET("tournaments")
    suspend fun getTournaments(): List<TournamentItem>
}