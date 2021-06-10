package com.sunasterisk.loltournaments.data.model

import com.google.gson.annotations.SerializedName

data class MatchResult(
    val score: Int,
    @SerializedName("team_id")
    val teamId: Int
)
