package com.sc941737.socialmediaapp.modules.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.sc941737.socialmediaapp.BR
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseViewHolder
import com.sc941737.socialmediaapp.repository.models.Post
import java.lang.IllegalArgumentException

class FeedAdapter (context: Context): ListAdapter<Post, BaseViewHolder<*>>(PostDiffCallback()) {
    // Using a generic ViewHolder implementation in case there were more types of posts to be listed together.
    // E.g. we might want to make the posts belonging to the current user look different - we would then override
    // the getItemViewType method.

    private val layoutInflater = LayoutInflater.from(context)
    lateinit var itemListener: PostItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PostViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false), itemListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val posts = currentList
        val post = posts[position]
        when(holder){
            is PostViewHolder -> holder.bind(post as Post)
            else -> throw IllegalArgumentException()
        }
    }

    inner class PostViewHolder(private val binding: ViewDataBinding, private val listener: PostItemListener) : BaseViewHolder<Post>(binding){
        override fun bind(item: Post) {
            super.bind(item)
            binding.setVariable(BR.listener, listener)
        }
    }

    interface PostItemListener {
        fun onClickLike(item:Post)
        fun onClickComments(item:Post)
    }
}