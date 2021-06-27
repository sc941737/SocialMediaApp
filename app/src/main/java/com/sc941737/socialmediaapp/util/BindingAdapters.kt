package com.sc941737.socialmediaapp.util

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sc941737.socialmediaapp.R

object BindingAdapters {

    @JvmStatic @BindingAdapter("imageUrl")
    fun setAvatar(view: ImageView, url: Uri?){
        if (url == null) return
        view.alpha = 1f
        Glide.with(view.context).load(url)
            .centerCrop().fitCenter()
            .placeholder(R.color.gray)
            .into(view)
    }
}