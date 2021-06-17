package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Opponent(
    val opponent: Team,
    val type: String
): Parcelable
