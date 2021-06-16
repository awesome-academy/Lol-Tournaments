package com.sunasterisk.loltournaments.data.repository

import com.sunasterisk.loltournaments.data.model.remote.League
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.data.model.remote.Team

interface LolRepository {
    suspend fun getLeagues(leagueIds: String, sortValue: String) : List<League>
    suspend fun getSeries(time: String, leagueId: Int) : List<Serie>
    suspend fun getTeamById(teamId: Int): List<Team>
}
