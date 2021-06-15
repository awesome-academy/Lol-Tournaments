package com.sunasterisk.loltournaments.ultils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sunasterisk.loltournaments.R

@BindingAdapter("loadImageUrl")
fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.ic_placeholder).into(this)
}
