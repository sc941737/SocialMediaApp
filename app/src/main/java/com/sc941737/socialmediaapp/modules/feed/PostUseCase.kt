package com.sc941737.socialmediaapp.modules.feed

import com.sc941737.socialmediaapp.repository.models.Post
import com.sc941737.socialmediaapp.repository.models.PostResponse
import com.sc941737.socialmediaapp.repository.models.UserResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PostUseCase @Inject constructor(private val repository: FeedRepository) {
    fun getAllPosts():List<Post> = runBlocking {
        val postsWithAuthors = ArrayList<Post>()
        val posts:List<PostResponse>? = async {
            val response = repository.getAllPosts()
            return@async response.body()
        }.await()
        val users:List<UserResponse>? = async {
            val response = repository.getAllUsers()
            return@async response.body()
        }.await()
        posts?.forEach{ post ->
            users?.first { user -> user.id == post.userId }?.also { author ->
                val postWithAuthor = Post(post, author)
                postsWithAuthors.add(postWithAuthor)
            }
        }
        return@runBlocking postsWithAuthors
    }
}