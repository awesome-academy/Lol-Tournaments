package com.sunasterisk.loltournaments.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseAdapter
import com.sunasterisk.loltournaments.base.BaseViewHolder
import com.sunasterisk.loltournaments.data.model.remote.Player
import com.sunasterisk.loltournaments.databinding.ItemPlayerBinding

class PlayerAdapter(
    private val onItemClick: (Player) -> Unit
) : BaseAdapter<Player, PlayerAdapter.ViewHolder>(Player.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_player, parent, false
        ),
        onItemClick
    )

    class ViewHolder(
        private val binding: ItemPlayerBinding,
        onItemClick: (Player) -> Unit
    ) : BaseViewHolder<Player>(binding, onItemClick) {

        override fun onBind(item: Player) {
            super.onBind(item)

            binding.imagePlayerRole.apply {
                item.role?.let {
                    when (it) {
                        ROLE_TOP -> setImageResource(R.drawable.ic_role_top)
                        ROLE_JUN -> setImageResource(R.drawable.ic_role_jun)
                        ROLE_MID -> setImageResource(R.drawable.ic_role_mid)
                        ROLE_ADC -> setImageResource(R.drawable.ic_role_adc)
                        ROLE_SUP -> setImageResource(R.drawable.ic_role_sup)
                        else -> null
                    }
                }
            }

            binding.player = item
        }
    }

    companion object {
        const val ROLE_TOP = "top"
        const val ROLE_JUN = "jun"
        const val ROLE_MID = "mid"
        const val ROLE_ADC = "adc"
        const val ROLE_SUP = "sup"
    }
}
