package com.sunasterisk.loltournaments.data.repository

import com.sunasterisk.loltournaments.data.model.remote.*

interface LolRepository {
    suspend fun getLeagues(leagueIds: String, sortValue: String) : List<League>
    suspend fun getSeries(time: String, leagueId: Int) : List<Serie>
    suspend fun getTournamentById(tournamentId: Int): List<Tournament>
    suspend fun getMatchByTournamentId( matchId: Int): List<Match>
    suspend fun getTeamById(teamId: Int): List<Team>
    suspend fun getTeams(page: Int) : List<Team>
    suspend fun getTeamByAcronym(teamAcronym: String, page: Int): List<Team>
    suspend fun getTeamByName(teamName: String, page: Int): List<Team>
}
