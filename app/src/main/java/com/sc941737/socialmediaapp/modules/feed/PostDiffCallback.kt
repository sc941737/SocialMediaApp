package com.sc941737.socialmediaapp.modules.feed

import androidx.recyclerview.widget.DiffUtil
import com.sc941737.socialmediaapp.repository.models.Post

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean
            = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean
            = oldItem == newItem

}