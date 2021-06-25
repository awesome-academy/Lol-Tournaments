package com.sunasterisk.loltournaments.data.source

import com.sunasterisk.loltournaments.data.model.local.PlayerLocal
import com.sunasterisk.loltournaments.data.model.local.TeamLocal
import com.sunasterisk.loltournaments.data.model.remote.*

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
        suspend fun getTournamentById(tournamentId: Int): List<Tournament>
        suspend fun getMatchByTournamentId(matchId: Int): List<Match>
        suspend fun getTeamById(teamId: Int): List<Team>
        suspend fun getTeams(page: Int) : List<Team>
        suspend fun getTeamByAcronym(teamAcronym: String, page: Int): List<Team>
        suspend fun getTeamByName(teamName: String, page: Int): List<Team>
    }
}
