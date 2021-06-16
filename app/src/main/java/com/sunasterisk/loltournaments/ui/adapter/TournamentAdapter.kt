package com.sunasterisk.loltournaments.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseAdapter
import com.sunasterisk.loltournaments.base.BaseViewHolder
import com.sunasterisk.loltournaments.base.SetDataAdapter
import com.sunasterisk.loltournaments.data.model.remote.Tournament
import com.sunasterisk.loltournaments.databinding.ItemTournamentBinding

class TournamentAdapter(
    private val onItemClick: (Tournament) -> Unit
) : BaseAdapter<Tournament, TournamentAdapter.ViewHolder>(Tournament.diffUtil),
    SetDataAdapter<Tournament> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_tournament, parent, false
        ),
        onItemClick
    )

    class ViewHolder(
        private val binding: ItemTournamentBinding,
        onItemClick: (Tournament) -> Unit
    ) : BaseViewHolder<Tournament>(binding, onItemClick) {
        override fun onBind(item: Tournament) {
            super.onBind(item)
            binding.tournament = item
        }
    }
}
