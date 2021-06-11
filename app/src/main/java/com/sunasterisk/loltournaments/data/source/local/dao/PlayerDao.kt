package com.sunasterisk.loltournaments.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sunasterisk.loltournaments.data.model.local.PlayerLocal

@Dao
interface PlayerDao {
    @Insert
    fun insertPlayer(playerLocal: PlayerLocal): Long

    @Query("SELECT * FROM players WHERE teamId = :teamId")
    fun getPlayerByTeamId(teamId: Int) : List<PlayerLocal>?

    @Delete
    fun deletePlayer(playerLocal: PlayerLocal): Int
}
