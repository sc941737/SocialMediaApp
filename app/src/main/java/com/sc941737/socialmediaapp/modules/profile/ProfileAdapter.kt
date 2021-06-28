package com.sc941737.socialmediaapp.modules.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.sc941737.socialmediaapp.BR
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseViewHolder
import com.sc941737.socialmediaapp.repository.models.Album

class ProfileAdapter (context: Context): ListAdapter<Album, BaseViewHolder<*>>(AlbumDiffCallback()) {

    private val layoutInflater = LayoutInflater.from(context)
    lateinit var itemListener: AlbumItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return AlbumViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_album, parent, false), itemListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val albums = currentList
        val album = albums[position]
        when(holder){
            is AlbumViewHolder -> holder.bind(album as Album)
            else -> throw IllegalArgumentException()
        }
    }

    inner class AlbumViewHolder(private val binding: ViewDataBinding, private val listener: AlbumItemListener) : BaseViewHolder<Album>(binding){
        override fun bind(item: Album) {
            super.bind(item)
            binding.setVariable(BR.listener, listener)
        }
    }

    interface AlbumItemListener {
        fun onClickAlbum(item: Album)
    }
}
