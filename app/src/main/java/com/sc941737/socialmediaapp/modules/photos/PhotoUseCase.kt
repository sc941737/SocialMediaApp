package com.sc941737.socialmediaapp.modules.photos

import com.sc941737.socialmediaapp.repository.models.Photo
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PhotoUseCase @Inject constructor(private val repository:PhotosRepository) {
    fun getAllPhotosForAlbum(albumId: Long): List<Photo> = runBlocking{
        return@runBlocking async {
            val response = repository.getAllPhotosForAlbum(albumId)
            return@async response.body()
        }.await() ?: arrayListOf()
    }
}
