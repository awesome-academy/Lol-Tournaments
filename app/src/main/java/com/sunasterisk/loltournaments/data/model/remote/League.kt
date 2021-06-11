package com.sunasterisk.loltournaments.data.model.remote

import com.google.gson.annotations.SerializedName

data class League(
    val id: Int,
    val name: String,
    val series: List<Serie>,
    @SerializedName("image_url")
    val imageUrl: String
)
