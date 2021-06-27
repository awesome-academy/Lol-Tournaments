package com.sunasterisk.loltournaments.ultils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListener(
    private val linearLayoutManager: LinearLayoutManager
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val totalItem = linearLayoutManager.itemCount
        val visibleItemCount = linearLayoutManager.childCount
        val firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()

        if (isScrolling()) return

        if (firstVisibleItemPosition + visibleItemCount >= totalItem) onScrollLastItem()
    }

    abstract fun onScrollLastItem()
    abstract fun isScrolling(): Boolean
}
