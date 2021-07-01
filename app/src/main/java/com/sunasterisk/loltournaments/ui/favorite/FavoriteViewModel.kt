package com.sunasterisk.loltournaments.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.data.model.remote.Player
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.data.repository.LolRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val lolRepository: LolRepository
) : BaseViewModel() {

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams


    fun getFavoriteTeams() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val teams = lolRepository.getAllLocalTeams()?.map {
                val team = it.toRemoteTeam()
                getPlayerByTeamId(it.id)?.let { players -> team.players = players }
                team
            }

            teams?.let { _teams.postValue(it) }

            _isLoading.postValue(false)
        }
    }

    private suspend fun getPlayerByTeamId(teamId: Int): List<Player>? {
        val players = lolRepository.getPlayerByTeamId(teamId)

        return players?.map {
            it.toRemotePlayer()
        }
    }
}
