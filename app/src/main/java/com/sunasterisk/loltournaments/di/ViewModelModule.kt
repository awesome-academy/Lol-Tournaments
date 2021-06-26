package com.sunasterisk.loltournaments.di

import com.sunasterisk.loltournaments.ui.home.HomeViewModel
import com.sunasterisk.loltournaments.ui.serie.SerieDetailsViewModel
import com.sunasterisk.loltournaments.ui.teams.TeamsViewModel
import com.sunasterisk.loltournaments.ui.tournament.TournamentDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SerieDetailsViewModel(get()) }
    viewModel { TournamentDetailsViewModel(get()) }
    viewModel { TeamsViewModel(get()) }
}
