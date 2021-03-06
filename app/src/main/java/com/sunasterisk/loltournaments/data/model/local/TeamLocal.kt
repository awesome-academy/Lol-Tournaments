package com.sunasterisk.loltournaments.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sunasterisk.loltournaments.data.model.remote.Team

@Entity(tableName = "teams")
data class TeamLocal(
    @PrimaryKey
    @ColumnInfo(name = "teamId")
    val id: Int,
    @ColumnInfo(name = "acronym")
    val acronym: String?,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,
    @ColumnInfo(name = "location")
    val location: String?,
    @ColumnInfo(name = "name")
    val name: String,
    val slug: String
) {
    fun toRemoteTeam() = Team(acronym, id, imageUrl, location, name, slug)
}
