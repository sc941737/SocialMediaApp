package com.sc941737.socialmediaapp.modules.photos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseViewHolder
import com.sc941737.socialmediaapp.repository.models.Photo
import java.lang.IllegalArgumentException

class PhotosAdapter(context: Context) : ListAdapter<Photo, BaseViewHolder<*>>(PhotosDiffCallback()) {
    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PhotoViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val photos = currentList
        val photo = photos[position]
        when(holder){
            is PhotoViewHolder -> holder.bind(photo as Photo)
            else -> throw IllegalArgumentException()
        }
    }

    inner class PhotoViewHolder(binding:ViewDataBinding):BaseViewHolder<Photo>(binding)
}
