package com.sc941737.socialmediaapp.modules.comments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseViewHolder
import com.sc941737.socialmediaapp.repository.models.Comment

class CommentsAdapter (context: Context): ListAdapter<Comment, BaseViewHolder<*>>(CommentDiffCallback()) {
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return CommentViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_comment, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val comments = currentList
        val comment = comments[position]
        when(holder){
            is CommentViewHolder -> holder.bind(comment as Comment)
            else -> throw IllegalArgumentException()
        }
    }

    inner class CommentViewHolder(binding: ViewDataBinding) : BaseViewHolder<Comment>(binding)
}
