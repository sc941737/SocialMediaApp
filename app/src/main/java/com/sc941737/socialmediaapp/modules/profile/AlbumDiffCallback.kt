package com.sc941737.socialmediaapp.modules.profile

import androidx.recyclerview.widget.DiffUtil
import com.sc941737.socialmediaapp.repository.models.Album

class AlbumDiffCallback: DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean
            = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean
            = oldItem == newItem
}
