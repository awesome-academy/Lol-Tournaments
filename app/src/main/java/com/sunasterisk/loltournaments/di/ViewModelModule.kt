package com.sunasterisk.loltournaments.di

import com.sunasterisk.loltournaments.ui.home.HomeViewModel
import com.sunasterisk.loltournaments.ui.serie.SerieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SerieDetailsViewModel(get()) }
}
