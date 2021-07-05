package com.sunasterisk.loltournaments.ultils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:textDate", "android:withHour", requireAll = false)
fun TextView.setTextDate(textDate: String?, withHour: Boolean) {
    this.text = convertTime(textDate, withHour)
}
