package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    val id: Int,
    val name: String,
    val series: List<Serie>,
    @SerializedName("image_url")
    val imageUrl: String
): Parcelable
