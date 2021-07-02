package com.sunasterisk.loltournaments.ui.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.data.model.remote.Player

class PlayerDetailsViewModel : BaseViewModel() {
    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player> = _player

    fun setPlayer(player: Player) {
        _player.value = player
    }
}
