package com.sc941737.socialmediaapp.modules.comments

import com.sc941737.socialmediaapp.repository.models.Comment
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class CommentUseCase @Inject constructor(private val repository: CommentsRepository) {
    fun getAllCommentsForPost(postId: Long): List<Comment> = runBlocking {
        return@runBlocking async {
            val response = repository.getAllCommentsForPost(postId)
            return@async response.body()
        }.await() ?: arrayListOf()
    }
}
