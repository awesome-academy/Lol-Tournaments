package com.sunasterisk.loltournaments.data.source.remote

import com.sunasterisk.loltournaments.data.model.remote.League
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.data.model.remote.Team
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(PATH_LEAGUE)
    suspend fun getLeagues(
        @Query(QUERY_FILTER_ID) leagueIds: String,
        @Query(QUERY_SORT) sortValue: String
    ): List<League>

    @GET("$PATH_SERIE/{$PATH_TIME}")
    suspend fun getSeries(
        @Path(PATH_TIME) time: String,
        @Query(QUERY_FILTER_LEAGUE_ID) leagueId: Int
    ): List<Serie>

    @GET(PATH_TEAM)
    suspend fun getTeamById(
        @Query(QUERY_FILTER_ID) teamId: Int
    ): List<Team>
}
