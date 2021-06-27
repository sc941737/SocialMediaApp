package com.sc941737.socialmediaapp.modules.feed

import com.sc941737.socialmediaapp.repository.SocialApi
import com.sc941737.socialmediaapp.repository.models.PostResponse
import com.sc941737.socialmediaapp.repository.models.UserResponse
import retrofit2.Response
import javax.inject.Inject

class FeedRepository @Inject constructor(private val api:SocialApi) {
    suspend fun getAllPosts(): Response<List<PostResponse>> = api.fetchAllPosts()
    suspend fun getAllUsers(): Response<List<UserResponse>> = api.fetchAllUsers()
}