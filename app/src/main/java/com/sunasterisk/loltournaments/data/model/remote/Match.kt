package com.sunasterisk.loltournaments.data.model.remote

import com.google.gson.annotations.SerializedName

data class Match(
    val name: String,
    @SerializedName("scheduled_at")
    val scheduledAt: String,
    @SerializedName("number_of_games")
    val numberOfGames: Int,
    val opponents: List<Opponent>,
    @SerializedName("league_id")
    val leagueId: Int,
    val league: League,
    @SerializedName("serie_id")
    val serieId: Int,
    val serie: Serie,
    @SerializedName("tournament_id")
    val tournamentId: Int,
    val tournament: Tournament,
    val winner: Team,
    val results: List<MatchResult>,
    val slug: String
)
