package com.sunasterisk.loltournaments.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<T>(
    binding: ViewDataBinding,
    onItemClick: (T) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    protected var item: T? = null

    init {
        binding.root.setOnClickListener {
            item?.let { onItemClick(it) }
        }
    }

    open fun onBind(item: T) {
        this.item = item
    }
}
