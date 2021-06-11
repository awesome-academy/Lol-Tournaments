package com.sunasterisk.loltournaments.data.model.remote

import com.google.gson.annotations.SerializedName

data class Tournament(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String,
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    val league: League,
    val matches: List<Match>,
    @SerializedName("full_name")
    val name: String,
    @SerializedName("prizepool")
    val prizePool: String,
    @SerializedName("serie_id")
    val serieId: Int,
    val serie: Serie,
    val slug: String,
    val teams: List<Team>,
    @SerializedName("winner_id")
    val winnerId: Int,
)
