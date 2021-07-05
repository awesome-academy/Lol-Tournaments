package com.sunasterisk.loltournaments.data.model.remote

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match(
    val id: Int,
    val name: String,
    @SerializedName("scheduled_at")
    val scheduledAt: String,
    @SerializedName("official_stream_url")
    val streamUrl: String,
    @SerializedName("number_of_games")
    val numberOfGames: Int,
    val opponents: List<Opponent>,
    @SerializedName("league_id")
    val leagueId: Int,
    val league: League,
    @SerializedName("serie_id")
    val serieId: Int,
    val serie: Serie,
    @SerializedName("tournament_id")
    val tournamentId: Int,
    val tournament: Tournament,
    val winner: Team,
    val results: List<MatchResult>,
    val slug: String
) : Parcelable {
    val titleName: String
        get() {
            if (name.matches(Regex(REGEX_MATCH))) {
                val nameSplit = name.split(COLON)
                return nameSplit.first() + COLON
            }
            return MATCH
        }
    val typeMatch: String get() = BO + numberOfGames

    fun getFirstTeam() = opponents.first().opponent
    fun getSecondTeam() = opponents.last().opponent
    fun getTitleNotification() = "${league.name} ${serie.name}"

    fun getScore(): String {
        val scoreFirstTeam = results.first().score
        val scoreSecondTeam = results.last().score

        if (scoreFirstTeam == ZERO && scoreSecondTeam == ZERO) {
            return VS
        }
        return "$scoreFirstTeam$DASH$scoreSecondTeam"
    }

    companion object {
        const val DASH = "-"
        const val COLON = ":"
        const val MATCH = "Match:"
        const val VS = "VS"
        const val BO = "BO"
        const val REGEX_MATCH = ".*: .*"
        const val ZERO = 0

        val diffUtil = object : DiffUtil.ItemCallback<Match>() {
            override fun areItemsTheSame(oldItem: Match, newItem: Match) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Match, newItem: Match) = oldItem == newItem
        }
    }
}
