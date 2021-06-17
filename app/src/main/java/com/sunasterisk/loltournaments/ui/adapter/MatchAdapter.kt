package com.sunasterisk.loltournaments.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseAdapter
import com.sunasterisk.loltournaments.base.BaseViewHolder
import com.sunasterisk.loltournaments.data.model.remote.Match
import com.sunasterisk.loltournaments.databinding.ItemMatchBinding

class MatchAdapter(
    private val onItemClick: (Match) -> Unit
) : BaseAdapter<Match, MatchAdapter.ViewHolder>(Match.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_match, parent, false
        ),
        onItemClick
    )

    class ViewHolder(
        private val binding: ItemMatchBinding,
        onItemClick: (Match) -> Unit
    ) : BaseViewHolder<Match>(binding, onItemClick) {

        override fun onBind(item: Match) {
            super.onBind(item)
            binding.match = item
        }
    }
}
