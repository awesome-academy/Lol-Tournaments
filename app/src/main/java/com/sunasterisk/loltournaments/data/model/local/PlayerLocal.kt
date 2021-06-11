package com.sunasterisk.loltournaments.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class PlayerLocal(
    @ColumnInfo(name = "teamId")
    val teamId: Int,
    @PrimaryKey
    @ColumnInfo(name = "playerId")
    val id: Int,
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "hometown")
    val hometown: String,
    @ColumnInfo(name = "nationality")
    val nationality: String,
    @ColumnInfo(name = "role")
    val role: String,
    @ColumnInfo(name = "slug")
    val slug: String
)
