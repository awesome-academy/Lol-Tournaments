package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import com.sunasterisk.loltournaments.data.model.local.TeamLocal
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val acronym: String?,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    val location: String,
    val name: String,
    var players: List<Player>,
    val slug: String
) : Parcelable {

    fun toLocalTeam() = TeamLocal(id, acronym, imageUrl, location, name, slug)

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(oldItem: Team, newItem: Team) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Team, newItem: Team) = oldItem == newItem
        }
    }
}
