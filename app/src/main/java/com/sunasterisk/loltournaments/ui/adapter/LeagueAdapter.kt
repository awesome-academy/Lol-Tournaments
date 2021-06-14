package com.sunasterisk.loltournaments.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.data.model.remote.League
import com.sunasterisk.loltournaments.databinding.ItemLeagueBinding

class LeagueAdapter(context: Context) : ArrayAdapter<League>(context, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = DataBindingUtil.inflate<ItemLeagueBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_league,
            parent,
            false
        )
        binding.league = getItem(position)
        return binding.root
    }

    fun setData(leagues: List<League>) {
        clear()
        addAll(leagues)
        notifyDataSetChanged()
    }
}
