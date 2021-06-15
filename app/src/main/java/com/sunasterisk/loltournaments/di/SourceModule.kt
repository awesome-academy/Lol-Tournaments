package com.sunasterisk.loltournaments.di

import com.sunasterisk.loltournaments.data.repository.LolRepository
import com.sunasterisk.loltournaments.data.repository.LolRepositoryImp
import com.sunasterisk.loltournaments.data.source.LolDataSource
import com.sunasterisk.loltournaments.data.source.local.LolLocalDataSource
import com.sunasterisk.loltournaments.data.source.remote.LolRemoteDataSource
import org.koin.dsl.module

val sourceModule = module {
    single<LolRepository> { LolRepositoryImp(get(), get()) }
    single<LolDataSource.Local> { LolLocalDataSource(get(), get()) }
    single<LolDataSource.Remote> { LolRemoteDataSource(get()) }
}
