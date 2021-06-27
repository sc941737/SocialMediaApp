package com.sc941737.socialmediaapp.modules.comments

import com.sc941737.socialmediaapp.repository.SocialApi
import com.sc941737.socialmediaapp.repository.models.Comment
import retrofit2.Response
import javax.inject.Inject

class CommentsRepository @Inject constructor(private val api:SocialApi) {
    // todo: persistence with Room
    suspend fun getAllCommentsForPost(postId: Long): Response<List<Comment>> = api.fetchAllCommentsForPost(postId)
}
