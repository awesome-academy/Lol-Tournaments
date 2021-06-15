package com.sunasterisk.loltournaments.data.model.remote

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Serie(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String,
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    val league: League,
    @SerializedName("full_name")
    val name: String,
    val season: String,
    val slug: String,
    val tier: String,
    val tournaments: List<Tournament>,
    @SerializedName("winner_id")
    val winnerId: Int,
    val year: Int
) {
    var background: Int? = null

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Serie>() {
            override fun areItemsTheSame(oldItem: Serie, newItem: Serie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Serie, newItem: Serie): Boolean {
                return oldItem == newItem
            }
        }
    }
}
