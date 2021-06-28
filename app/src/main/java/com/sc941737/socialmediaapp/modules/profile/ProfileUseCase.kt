package com.sc941737.socialmediaapp.modules.profile

import com.sc941737.socialmediaapp.repository.models.User
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ProfileUseCase @Inject constructor(private val repository: ProfileRepository){

    fun getUserForId(userId: Long): User? = runBlocking{
        var user:User? = null
        val albums = async {
            val response = repository.getAllAlbumsForUser(userId)
            return@async response.body()
        }.await() ?: arrayListOf()
        val userResponse = async {
            val response  = repository.getUserForId(userId)
            return@async response.body()
        }.await()
        userResponse?.let {
            user = User(it.first(), albums)
        }
        return@runBlocking user
    }

}
