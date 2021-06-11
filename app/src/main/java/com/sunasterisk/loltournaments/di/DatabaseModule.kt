package com.sunasterisk.loltournaments.di

import android.content.Context
import androidx.room.Room
import com.sunasterisk.loltournaments.data.source.local.database.LolDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { initDatabase(androidContext()) }
    single { get<LolDatabase>().playerDao() }
    single { get<LolDatabase>().teamDao() }
}

fun initDatabase(context: Context) = Room.databaseBuilder(
    context,
    LolDatabase::class.java,
    LolDatabase.DATABASE_NAME
).build()
