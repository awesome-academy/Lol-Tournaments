package com.sunasterisk.loltournaments.ui.tournament

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.data.model.remote.Match
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.data.model.remote.Tournament
import com.sunasterisk.loltournaments.data.repository.LolRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TournamentDetailsViewModel(private val lolRepository: LolRepository) : BaseViewModel() {
    private val _tournament = MutableLiveData<Tournament>()
    val tournament: LiveData<Tournament> get() = _tournament

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> get() = _matches

    private val _winner = MutableLiveData<Team>()
    val winner get() = _winner

    fun getData(tournament: Tournament) {
        getTournaments(tournament.id)
        tournament.winnerId?.let { getTeam(it) }
        getMatches(tournament.id)
    }

    private fun getTournaments(tournamentId: Int) {
        _isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _tournament.postValue(lolRepository.getTournamentById(tournamentId).first())
            _isLoading.postValue(false)
        }
    }

    private fun getMatches(tournamentId: Int) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _matches.postValue(lolRepository.getMatchByTournamentId(tournamentId))
        }
    }

    private fun getTeam(teamId: Int) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _winner.postValue(lolRepository.getTeamById(teamId).first())
        }
    }
}
