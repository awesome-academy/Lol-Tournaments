package com.sunasterisk.loltournaments.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseAdapter
import com.sunasterisk.loltournaments.base.BaseViewHolder
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.databinding.ItemSerieBinding

class SerieAdapter(
    private val onItemClick: (Serie) -> Unit
) : BaseAdapter<Serie, SerieAdapter.ViewHolder>(Serie.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_serie,
            parent,
            false
        ),
        onItemClick
    )

    class ViewHolder(
        private val binding: ItemSerieBinding,
        onItemClick: (Serie) -> Unit
    ) : BaseViewHolder<Serie>(binding, onItemClick) {
        override fun onBind(item: Serie) {
            super.onBind(item)
            item.background = when (adapterPosition % BACKGROUND_COUNT) {
                POSITION_0 -> R.drawable.serie_background_1
                POSITION_1 -> R.drawable.serie_background_2
                POSITION_2 -> R.drawable.serie_background_3
                POSITION_3 -> R.drawable.serie_background_4
                POSITION_4 -> R.drawable.serie_background_5
                POSITION_5 -> R.drawable.serie_background_6
                POSITION_6 -> R.drawable.serie_background_7
                POSITION_7 -> R.drawable.serie_background_8
                POSITION_8 -> R.drawable.serie_background_9
                POSITION_9 -> R.drawable.serie_background_10
                else -> R.drawable.serie_background_1
            }

            item.background?.let { binding.imageSerie.setImageResource(it) }
            binding.serie = item
        }
    }

    companion object {
        const val POSITION_0 = 0
        const val POSITION_1 = 1
        const val POSITION_2 = 2
        const val POSITION_3 = 3
        const val POSITION_4 = 4
        const val POSITION_5 = 5
        const val POSITION_6 = 6
        const val POSITION_7 = 7
        const val POSITION_8 = 8
        const val POSITION_9 = 9
        const val BACKGROUND_COUNT = 10
    }
}
