package com.sc941737.socialmediaapp.modules.comments

import androidx.recyclerview.widget.DiffUtil
import com.sc941737.socialmediaapp.repository.models.Comment

class CommentDiffCallback: DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean
            = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean
            = oldItem == newItem
}
