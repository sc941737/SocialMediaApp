package com.sc941737.socialmediaapp.modules.profile

import com.sc941737.socialmediaapp.repository.SocialApi
import com.sc941737.socialmediaapp.repository.models.Album
import com.sc941737.socialmediaapp.repository.models.UserResponse
import retrofit2.Response
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val api:SocialApi){
    suspend fun getAllAlbumsForUser(userId: Long): Response<List<Album>> = api.fetchAllAlbumsForUser(userId)
    suspend fun getUserForId(userId: Long): Response<List<UserResponse>> = api.fetchUserOfId(userId)
}
