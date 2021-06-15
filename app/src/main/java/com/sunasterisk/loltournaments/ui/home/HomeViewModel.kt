package com.sunasterisk.loltournaments.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.data.model.remote.League
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.data.repository.LolRepository
import com.sunasterisk.loltournaments.data.source.remote.PATH_COMPLETED
import com.sunasterisk.loltournaments.data.source.remote.PATH_RUNNING
import com.sunasterisk.loltournaments.data.source.remote.PATH_UPCOMING
import com.sunasterisk.loltournaments.ultils.toListString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val lolRepository: LolRepository) : BaseViewModel() {
    private val _leagues = MutableLiveData<List<League>>()
    val leagues: LiveData<List<League>> get() = _leagues

    private val _leagueId = MutableLiveData<Int>()
    private val leagueId: LiveData<Int> get() = _leagueId

    private val _serieCompleted = MutableLiveData<List<Serie>>()
    val serieCompleted: LiveData<List<Serie>>
        get() = Transformations.switchMap(leagueId) {
            getSerie(_serieCompleted, it, PATH_COMPLETED)
            _serieCompleted
        }

    private val _serieRunning = MutableLiveData<List<Serie>>()
    val serieRunning: LiveData<List<Serie>>
        get() = Transformations.switchMap(leagueId) {
            getSerie(_serieRunning, it, PATH_RUNNING)
            _serieRunning
        }

    private val _serieUpcoming = MutableLiveData<List<Serie>>()
    val serieUpcoming: LiveData<List<Serie>>
        get() = Transformations.switchMap(leagueId) {
            getSerie(_serieUpcoming, it, PATH_UPCOMING)
            _serieUpcoming
        }

    fun getLeagues(leagueIds: List<Int>, sortValue: String) {
        _isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val leagues = lolRepository.getLeagues(leagueIds.toListString(), sortValue)
            _leagues.postValue(leagues)
            _isLoading.postValue(false)
        }
    }

    fun setCurrentLeagueId(leagueId: Int) {
        _leagueId.value = leagueId
    }

    private fun getSerie(serie: MutableLiveData<List<Serie>>, leagueId: Int, pathTime: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            serie.postValue(lolRepository.getSeries(pathTime, leagueId))
        }
    }
}
