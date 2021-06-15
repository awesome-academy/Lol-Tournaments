package com.sunasterisk.loltournaments.data.source.remote

import com.sunasterisk.loltournaments.data.source.LolDataSource

class LolRemoteDataSource(
    private val apiService: ApiService
) : LolDataSource.Remote {
    override suspend fun getLeagues(leagueIds: String, sortValue: String) = apiService.getLeagues(leagueIds, sortValue)
    override suspend fun getSeries(time: String, leagueId: Int) = apiService.getSeries(time, leagueId)
}
