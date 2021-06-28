package com.sc941737.socialmediaapp.modules.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sc941737.socialmediaapp.repository.models.User
import javax.inject.Inject
import kotlin.properties.Delegates

@Suppress("ProtectedInFinal")
class ProfileViewModel : ViewModel() {
    @Inject protected lateinit var profileUseCase: ProfileUseCase
    var currentUserId by Delegates.notNull<Long>()
    val user: LiveData<User?> = liveData {
        emit(profileUseCase.getUserForId(currentUserId))
    }
}