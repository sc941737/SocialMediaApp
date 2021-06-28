package com.sc941737.socialmediaapp.modules.photos

import com.sc941737.socialmediaapp.repository.SocialApi
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val api:SocialApi){
    suspend fun getAllPhotosForAlbum(albumId: Long) = api.fetchAllPhotosForAlbum(albumId)
}
