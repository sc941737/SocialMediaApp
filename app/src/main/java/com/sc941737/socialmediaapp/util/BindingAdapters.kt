package com.sc941737.socialmediaapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.sc941737.socialmediaapp.R


object BindingAdapters {

    @JvmStatic @BindingAdapter("imageUrl")
    fun setImage(view: ImageView, url: String?){
        if (url == null) return
        view.alpha = 1f
        // via.placeholder.com seems to require a User-Agent header:
        val glideUrl = GlideUrl(url, LazyHeaders.Builder()
                .addHeader("User-Agent", "social-media-app")
                .build())
        Glide.with(view.context).load(glideUrl)
            .centerCrop().fitCenter()
            .placeholder(R.color.gray)
            .into(view)
    }
}