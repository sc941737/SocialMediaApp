package com.sc941737.socialmediaapp.modules.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sc941737.socialmediaapp.repository.models.Post

class FeedViewModel : ViewModel() {
    val posts:MutableLiveData<List<Post>> = MutableLiveData()
}