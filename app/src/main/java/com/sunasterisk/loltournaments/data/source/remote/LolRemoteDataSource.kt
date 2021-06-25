package com.sunasterisk.loltournaments.data.source.remote

import com.sunasterisk.loltournaments.data.source.LolDataSource

class LolRemoteDataSource(
    private val apiService: ApiService
) : LolDataSource.Remote {
    override suspend fun getLeagues(leagueIds: String, sortValue: String) = apiService.getLeagues(leagueIds, sortValue)
    override suspend fun getSeries(time: String, leagueId: Int) = apiService.getSeries(time, leagueId)
    override suspend fun getTournamentById(tournamentId: Int) = apiService.getTournamentById(tournamentId)
    override suspend fun getMatchByTournamentId(matchId: Int) = apiService.getMatchByTournamentId(matchId)
    override suspend fun getTeamById(teamId: Int) = apiService.getTeamById(teamId)
    override suspend fun getTeams(page: Int) = apiService.getTeams(page)
    override suspend fun getTeamByAcronym(teamAcronym: String, page: Int) = apiService.getTeamByAcronym(teamAcronym, page)
    override suspend fun getTeamByName(teamName: String, page: Int) = apiService.getTeamByName(teamName, page)
}
