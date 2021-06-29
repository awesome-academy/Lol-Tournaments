package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    @SerializedName("current_team")
    val currentTeam: Team?,
    val id: Int,
    val birthday: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val name: String,
    val hometown: String,
    val nationality: String,
    val role: String?,
    val slug: String
) : Parcelable {
    val fullName: String
        get() = "$firstName $lastName"

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Player>() {
            override fun areItemsTheSame(oldItem: Player, newItem: Player) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Player, newItem: Player) = oldItem == newItem
        }
    }
}
