package com.sunasterisk.loltournaments

import android.app.Application
import com.sunasterisk.loltournaments.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LolApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LolApplication)
            modules(listOf(networkModule))
        }
    }
}
