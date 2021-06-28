package com.sunasterisk.loltournaments.data.source.local

import com.sunasterisk.loltournaments.data.model.local.PlayerLocal
import com.sunasterisk.loltournaments.data.model.local.TeamLocal
import com.sunasterisk.loltournaments.data.source.LolDataSource
import com.sunasterisk.loltournaments.data.source.local.dao.PlayerDao
import com.sunasterisk.loltournaments.data.source.local.dao.TeamDao

class LolLocalDataSource(
    private val playerDao: PlayerDao,
    private val teamDao: TeamDao) :
    LolDataSource.Local {

    override suspend fun insertTeam(teamLocal: TeamLocal) = teamDao.insertTeam(teamLocal)
    override suspend fun getAllTeams() = teamDao.getAllTeams()
    override suspend fun getTeamById(teamId: Int) = teamDao.getTeamById(teamId)
    override suspend fun deleteTeam(teamLocal: TeamLocal) = teamDao.deleteTeam(teamLocal)

    override suspend fun insertPlayer(playerLocal: PlayerLocal) = playerDao.insertPlayer(playerLocal)
    override suspend fun getPlayerByTeamId(teamId: Int) = playerDao.getPlayerByTeamId(teamId)
    override suspend fun deletePlayer(playerLocal: PlayerLocal) = playerDao.deletePlayer(playerLocal)
}
