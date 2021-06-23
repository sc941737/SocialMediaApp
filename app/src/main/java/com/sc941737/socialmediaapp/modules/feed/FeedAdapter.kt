package com.sc941737.socialmediaapp.modules.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseViewHolder
import com.sc941737.socialmediaapp.repository.models.Post

class FeedAdapter (context: Context): ListAdapter<Post, BaseViewHolder<*>>(PostDiffCallback()) {
    // Using a generic ViewHolder implementation in case there were more types of posts to be listed together.
    // E.g. we might want to make the posts belonging to the current user look different - we would then override
    // the getItemViewType method.

    private val layoutInflater = LayoutInflater.from(context)
    lateinit var viewModel:FeedViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PostViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val posts = currentList
        val post = posts[position]
        when(holder){
            is PostViewHolder -> holder.bind(post as Post)
            else -> throw java.lang.IllegalArgumentException()
        }
    }

    inner class PostViewHolder(binding: ViewDataBinding) : BaseViewHolder<Post>(binding)
}