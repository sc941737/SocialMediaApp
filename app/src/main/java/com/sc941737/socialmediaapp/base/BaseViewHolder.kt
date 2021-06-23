package com.sc941737.socialmediaapp.base

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    open fun bind(item: T){
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}