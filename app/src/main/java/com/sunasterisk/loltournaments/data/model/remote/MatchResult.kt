package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchResult(
    val score: Int,
    @SerializedName("team_id")
    val teamId: Int
): Parcelable
