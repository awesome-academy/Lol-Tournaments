package com.sunasterisk.loltournaments.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sunasterisk.loltournaments.data.model.local.TeamLocal

@Dao
interface TeamDao {
    @Insert
    fun insertTeam(teamLocal: TeamLocal): Long

    @Query("SELECT * FROM teams")
    fun getAllTeams(): List<TeamLocal>?

    @Query("SELECT * FROM teams WHERE teamId = :teamId")
    fun getTeamById(teamId: Int): List<TeamLocal>?

    @Delete
    fun deleteTeam(teamLocal: TeamLocal): Int
}
