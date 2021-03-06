package com.sunasterisk.loltournaments.ui.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.data.repository.LolRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeamDetailsViewModel(private val lolRepository: LolRepository) : BaseViewModel() {
    private val _team = MutableLiveData<Team>()
    val team: LiveData<Team> get() = _team

    private var _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    fun getTeam(team: Team) {
        if (team.players.isNullOrEmpty()) {
            viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
                val team = lolRepository.getTeamById(team.id).first().apply { setPlayersId() }
                _team.postValue(team)
            }
        } else {
            team.setPlayersId()
            _team.value = team

        }
        getFavorite(team.id)
    }

    private fun getFavorite(teamId: Int) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val team = lolRepository.getLocalTeamById(teamId)
            _isFavorite.postValue(!team.isNullOrEmpty())
        }
    }

    fun setFavorite() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            team.value?.let {
                if (isFavorite.value == false) {
                    lolRepository.insertLocalTeam(it.toLocalTeam())
                    for (player in it.players) {
                        lolRepository.insertLocalPlayer(player.toLocalPlayer())
                    }
                } else {
                    lolRepository.deleteLocalTeam(it.toLocalTeam())
                    for (player in it.players) {
                        lolRepository.deleteLocalPlayer(player.toLocalPlayer())
                    }
                }

                getFavorite(it.id)
            }
        }
    }
}
