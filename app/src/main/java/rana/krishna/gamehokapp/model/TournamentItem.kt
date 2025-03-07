package rana.krishna.gamehokapp.model

data class TournamentItem(
    val entryFees: Int,
    val gameName: String,
    val id: Int,
    val name: String,
    val organizerDetails: OrganizerDetails,
    val prizeCoins: String,
    val registeredCount: Int,
    val registrationEndTime: Int,
    val status: String,
    val teamSize: String,
    val thumbnailPath: String,
    val totalCount: Int,
    val tournamentStartTime: Int
)