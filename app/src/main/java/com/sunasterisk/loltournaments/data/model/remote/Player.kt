package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    @SerializedName("current_team")
    val currentTeam: Team,
    val id: Int,
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
): Parcelable
