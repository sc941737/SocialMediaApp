package com.sc941737.socialmediaapp.modules.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sc941737.socialmediaapp.repository.models.Post
import javax.inject.Inject

// Dagger doesn't support injection into private fields, but it works with protected fields,
// which are effectively private in this context, but that gives us a lint warning.
@Suppress("ProtectedInFinal")
class FeedViewModel: ViewModel() {
    @Inject protected lateinit var postUseCase: PostUseCase
    val posts: LiveData<List<Post>> = liveData {
        emit(postUseCase.getAllPosts())
    }
}