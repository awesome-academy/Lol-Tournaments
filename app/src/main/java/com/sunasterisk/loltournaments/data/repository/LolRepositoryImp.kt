package com.sunasterisk.loltournaments.data.repository

import com.sunasterisk.loltournaments.data.model.local.TeamLocal
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.data.source.LolDataSource

class LolRepositoryImp(
    private val remote: LolDataSource.Remote,
    private val local: LolDataSource.Local
) : LolRepository {
    override suspend fun insertLocalTeam(teamLocal: TeamLocal) = local.insertTeam(teamLocal)
    override suspend fun getLocalTeamById(teamId: Int) = local.getTeamById(teamId)
    override suspend fun deleteLocalTeam(teamLocal: TeamLocal) = local.deleteTeam(teamLocal)

    override suspend fun getLeagues(leagueIds: String, sortValue: String) = remote.getLeagues(leagueIds, sortValue)
    override suspend fun getSeries(time: String, leagueId: Int): List<Serie> = remote.getSeries(time, leagueId)
    override suspend fun getTournamentById(tournamentId: Int) = remote.getTournamentById(tournamentId)
    override suspend fun getMatchByTournamentId(matchId: Int) = remote.getMatchByTournamentId(matchId)
    override suspend fun getTeamById(teamId: Int) = remote.getTeamById(teamId)
    override suspend fun getTeams(page: Int) = remote.getTeams(page)
    override suspend fun getTeamByAcronym(teamAcronym: String, page: Int) = remote.getTeamByAcronym(teamAcronym, page)
    override suspend fun getTeamByName(teamName: String, page: Int) = remote.getTeamByName(teamName, page)
}
