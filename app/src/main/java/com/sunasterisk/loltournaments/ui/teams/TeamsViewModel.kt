package com.sunasterisk.loltournaments.ui.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.data.repository.LolRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeamsViewModel(private val lolRepository: LolRepository) : BaseViewModel() {
    private val currentPage = MutableLiveData<Int>()
    private val teamAcronym = MutableLiveData<String>()

    private val _isSearchMode = MutableLiveData(false)
    val isSearchMode: LiveData<Boolean> get() = _isSearchMode

    private val _isLastPage = MutableLiveData(false)
    val isLastPage: LiveData<Boolean> = _isLastPage

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = Transformations.switchMap(currentPage) {
        if (isSearchMode.value == true) {
            teamAcronym.value?.let { acronym -> getTeamByAcronym(acronym, it) }
        } else {
            getTeams(it)
        }
        _teams
    }

    private fun getTeams(page: Int) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val currentTeams = mutableListOf<Team>()
            val teamsLoaded = lolRepository.getTeams(page)

            if (currentPage.value != FIRST_PAGE) {
                teams.value?.let { currentTeams.addAll(it) }
            }

            if (!teamsLoaded.isNullOrEmpty()) {
                currentTeams.addAll(teamsLoaded)
                _teams.postValue(currentTeams)
            } else {
                _isLastPage.postValue(true)
            }
            _isLoading.postValue(false)
        }
    }

    private fun getTeamByAcronym(teamAcronym: String, page: Int) {
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val currentTeams = mutableListOf<Team>()
            val teamsLoaded = lolRepository.getTeamByAcronym(teamAcronym, page)

            if (currentPage.value != FIRST_PAGE) {
                teams.value?.let { currentTeams.addAll(it) }
            }

            currentTeams.addAll(teamsLoaded)
            _teams.postValue(currentTeams)

            if (teamsLoaded.isNullOrEmpty()) {
                if (currentPage.value == FIRST_PAGE) getTeamByName(teamAcronym, page)
                _isLastPage.postValue(true)
            }

            _isLoading.postValue(false)
        }
    }

    private fun getTeamByName(teamName: String, page: Int) {
        _isLoading.postValue(true)

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val currentTeams = mutableListOf<Team>()
            val teamsLoaded = lolRepository.getTeamByName(teamName, page)

            if (currentPage.value != FIRST_PAGE) {
                teams.value?.let { currentTeams.addAll(it) }
            }
            currentTeams.addAll(teamsLoaded)
            _teams.postValue(currentTeams)
            if (teamsLoaded.isNullOrEmpty()) _isLastPage.postValue(true)
            _isLoading.postValue(false)
        }
    }

    fun setSearchMode(isSearchMode: Boolean) {
        this._isSearchMode.value = isSearchMode
        currentPage.value = FIRST_PAGE
        _isLastPage.value = false
        _isLoading.value = true
    }

    fun increaseCurrentPage() {
        currentPage.value = currentPage.value?.plus(1)
    }

    fun setTeamAcronym(teamAcronym: String) {
        this.teamAcronym.value = teamAcronym
    }

    companion object {
        const val FIRST_PAGE = 1
    }
}
