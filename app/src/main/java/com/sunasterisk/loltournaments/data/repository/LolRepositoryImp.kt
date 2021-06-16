package com.sunasterisk.loltournaments.data.repository

import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.data.source.LolDataSource

class LolRepositoryImp(
    private val remote: LolDataSource.Remote,
    private val local: LolDataSource.Local
) : LolRepository {
    override suspend fun getLeagues(leagueIds: String, sortValue: String) = remote.getLeagues(leagueIds, sortValue)
    override suspend fun getSeries(time: String, leagueId: Int): List<Serie> = remote.getSeries(time, leagueId)
    override suspend fun getTeamById(teamId: Int) = remote.getTeamById(teamId)
}
