package com.sunasterisk.loltournaments.data.model

import com.google.gson.annotations.SerializedName

data class Serie(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String,
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    val league: League,
    @SerializedName("full_name")
    val name: String,
    val season: String,
    val slug: String,
    val tier: String,
    val tournaments: List<Tournament>,
    @SerializedName("winner_id")
    val winnerId: Int,
    val year: Int
)
