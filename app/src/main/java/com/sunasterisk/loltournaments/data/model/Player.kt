package com.sunasterisk.loltournaments.data.model

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("current_team")
    val currentTeam: Team,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val name: String,
    val hometown: String,
    val nationality: String,
    val role: String,
    val slug: String
)
