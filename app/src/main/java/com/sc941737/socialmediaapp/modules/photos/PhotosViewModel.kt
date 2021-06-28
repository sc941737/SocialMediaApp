package com.sc941737.socialmediaapp.modules.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sc941737.socialmediaapp.repository.models.Photo
import javax.inject.Inject
import kotlin.properties.Delegates

@Suppress("ProtectedInFinal")
class PhotosViewModel : ViewModel() {
    @Inject protected lateinit var photoUseCase: PhotoUseCase
    var albumId by Delegates.notNull<Long>()
    val photos: LiveData<List<Photo>> = liveData {
        emit(photoUseCase.getAllPhotosForAlbum(albumId))
    }
}