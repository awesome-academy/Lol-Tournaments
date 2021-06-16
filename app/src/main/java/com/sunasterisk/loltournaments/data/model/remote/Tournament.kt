package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Tournament(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String,
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    val league: @RawValue League,
    val matches: @RawValue List<Match>,
    val name: String,
    @SerializedName("prizepool")
    val prizePool: String,
    @SerializedName("serie_id")
    val serieId: Int,
    val serie: Serie,
    val slug: String,
    val teams: @RawValue List<Team>,
    @SerializedName("winner_id")
    val winnerId: Int,
) : Parcelable {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Tournament>() {
            override fun areItemsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
                return oldItem == newItem
            }
        }
    }
}
