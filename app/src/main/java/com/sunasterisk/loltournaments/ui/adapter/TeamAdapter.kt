package com.sunasterisk.loltournaments.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseAdapter
import com.sunasterisk.loltournaments.base.BaseViewHolder
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.databinding.ItemTeamBinding

class TeamAdapter(
    private val onItemClick: (Team) -> Unit
) : BaseAdapter<Team, TeamAdapter.ViewHolder>(Team.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_team, parent, false
        ),
        onItemClick
    )

    class ViewHolder(
        private val binding: ItemTeamBinding,
        onItemClick: (Team) -> Unit
    ) : BaseViewHolder<Team>(binding, onItemClick) {

        override fun onBind(item: Team) {
            super.onBind(item)
            binding.team = item
        }
    }
}
