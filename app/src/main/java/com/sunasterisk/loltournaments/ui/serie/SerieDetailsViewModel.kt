package com.sunasterisk.loltournaments.ui.serie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.data.repository.LolRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SerieDetailsViewModel(private val lolRepository: LolRepository) : BaseViewModel() {
    private val _serie = MutableLiveData<Serie>()
    val serie: LiveData<Serie> get() = _serie

    private val _winner = MutableLiveData<Team>()
    val winner get() = _winner

    fun setSerie(serie: Serie) {
        getTeam(serie.winnerId)
        _serie.value = serie
    }

    private fun getTeam(teamId: Int) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _winner.postValue(lolRepository.getTeamById(teamId).first())
        }
    }
}
