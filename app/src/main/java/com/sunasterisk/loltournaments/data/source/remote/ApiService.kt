package com.sunasterisk.loltournaments.data.source.remote

import com.sunasterisk.loltournaments.data.model.remote.*
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

    @GET(PATH_TOURNAMENT)
    suspend fun getTournamentById(
        @Query(QUERY_FILTER_ID) tournamentId: Int
    ): List<Tournament>

    @GET(PATH_MATCH)
    suspend fun getMatchByTournamentId(
        @Query(QUERY_FILTER_TOURNAMENT_ID) matchId: Int,
        @Query(QUERY_SEARCH_PER_PAGE) perPage: Int = PER_PAGE_100
    ): List<Match>

    @GET(PATH_TEAM)
    suspend fun getTeamById(
        @Query(QUERY_FILTER_ID) teamId: Int
    ): List<Team>

    @GET(PATH_TEAM)
    suspend fun getTeams(
        @Query(QUERY_SEARCH_PAGE) page: Int
    ): List<Team>

    @GET(PATH_TEAM)
    suspend fun getTeamByAcronym(
        @Query(QUERY_SEARCH_TEAM_ACRONYM) teamAcronym: String,
        @Query(QUERY_SEARCH_PAGE) page: Int
    ): List<Team>

    @GET(PATH_TEAM)
    suspend fun getTeamByName(
        @Query(QUERY_SEARCH_TEAM_NAME) teamName: String,
        @Query(QUERY_SEARCH_PAGE) page: Int
    ): List<Team>
}
