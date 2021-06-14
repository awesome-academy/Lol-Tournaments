package com.sunasterisk.loltournaments.ultils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.loltournaments.base.SetDataAdapter

@BindingAdapter("android:data")
fun <T> RecyclerView.setData(data: List<T>?) {
    (adapter as SetDataAdapter<T>).setData(data)
}
