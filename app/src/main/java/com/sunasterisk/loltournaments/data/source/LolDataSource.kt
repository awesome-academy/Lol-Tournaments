package com.sunasterisk.loltournaments.data.source

import com.sunasterisk.loltournaments.data.model.local.PlayerLocal
import com.sunasterisk.loltournaments.data.model.local.TeamLocal

interface LolDataSource {
    interface Local {
        suspend fun insertTeam(teamLocal: TeamLocal): Long
        suspend fun getAllTeams(): List<TeamLocal>?
        suspend fun deleteTeam(teamLocal: TeamLocal): Int

        suspend fun insertPlayer(playerLocal: PlayerLocal): Long
        suspend fun getPlayerByTeamId(teamId: Int): List<PlayerLocal>?
        suspend fun deletePlayer(playerLocal: PlayerLocal): Int
    }
}
