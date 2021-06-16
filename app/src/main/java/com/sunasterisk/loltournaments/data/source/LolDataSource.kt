package com.sunasterisk.loltournaments.data.source

import com.sunasterisk.loltournaments.data.model.local.PlayerLocal
import com.sunasterisk.loltournaments.data.model.local.TeamLocal
import com.sunasterisk.loltournaments.data.model.remote.League
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.data.model.remote.Team

interface LolDataSource {
    interface Local {
        suspend fun insertTeam(teamLocal: TeamLocal): Long
        suspend fun getAllTeams(): List<TeamLocal>?
        suspend fun deleteTeam(teamLocal: TeamLocal): Int

        suspend fun insertPlayer(playerLocal: PlayerLocal): Long
        suspend fun getPlayerByTeamId(teamId: Int): List<PlayerLocal>?
        suspend fun deletePlayer(playerLocal: PlayerLocal): Int
    }

    interface Remote {
        suspend fun getLeagues(leagueIds: String, sortValue: String): List<League>
        suspend fun getSeries(time: String, leagueId: Int) : List<Serie>
        suspend fun getTeamById(teamId: Int): List<Team>
    }
}
