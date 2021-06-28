package com.sc941737.socialmediaapp.modules.photos

import androidx.recyclerview.widget.DiffUtil
import com.sc941737.socialmediaapp.repository.models.Photo

class PhotosDiffCallback: DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean
            = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean
            = oldItem == newItem
}
