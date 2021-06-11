package com.sunasterisk.loltournaments.di

import com.sunasterisk.loltournaments.data.source.local.LolLocalDataSource
import org.koin.dsl.module

val sourceModule = module {
    single { LolLocalDataSource(get(), get()) }
}
