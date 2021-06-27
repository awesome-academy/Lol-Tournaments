package com.sunasterisk.loltournaments.ultils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sunasterisk.loltournaments.R

@BindingAdapter("loadImageUrl", "placeholder", "circleCrop", requireAll = false)
fun ImageView.loadImage(url: String?, placeholder: Int?, circleCrop: Boolean) {
    url?.let {
        if (placeholder != null) {
            if (circleCrop) {
                Glide.with(this).load(it).placeholder(placeholder).circleCrop().into(this)
            } else {
                Glide.with(this).load(it).placeholder(placeholder).into(this)
            }
        } else {
            Glide.with(this).load(it).placeholder(R.drawable.ic_placeholder).into(this)
        }
    }
}
