package com.eunhye.dabang_test.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["loadUrl"])
fun ImageView.loadUrl(url: String?) {
    if (url.isNullOrBlank()) {
        return
    }

    url.let {
        Glide.with(this)
                .load(it)
                .into(this)
    }
}