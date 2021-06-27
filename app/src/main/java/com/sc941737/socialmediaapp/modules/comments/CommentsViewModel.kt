package com.sc941737.socialmediaapp.modules.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sc941737.socialmediaapp.repository.models.Comment
import javax.inject.Inject
import kotlin.properties.Delegates

@Suppress("ProtectedInFinal")
class CommentsViewModel : ViewModel() {
    @Inject protected lateinit var commentUseCase: CommentUseCase
    var postId by Delegates.notNull<Long>()
    val comments: LiveData<List<Comment>> = liveData {
        emit(commentUseCase.getAllCommentsForPost(postId))
    }
}