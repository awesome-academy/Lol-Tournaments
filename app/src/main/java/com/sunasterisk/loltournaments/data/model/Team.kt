package com.sunasterisk.loltournaments.data.model

import com.google.gson.annotations.SerializedName

data class Team(
    val acronym: String,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    val location: String,
    val name: String,
    val players: List<Player>,
    val slug: String
)
