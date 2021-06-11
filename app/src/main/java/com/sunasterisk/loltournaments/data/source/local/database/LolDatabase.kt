package com.sunasterisk.loltournaments.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sunasterisk.loltournaments.data.model.local.PlayerLocal
import com.sunasterisk.loltournaments.data.model.local.TeamLocal
import com.sunasterisk.loltournaments.data.source.local.dao.PlayerDao
import com.sunasterisk.loltournaments.data.source.local.dao.TeamDao

@Database(
    entities = [TeamLocal::class, PlayerLocal::class],
    version = LolDatabase.VERSION,
    exportSchema = false
)
abstract class LolDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun teamDao(): TeamDao

    companion object {
        const val DATABASE_NAME = "lol.db"
        const val VERSION = 1
    }
}
