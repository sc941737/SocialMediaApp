package com.sc941737.socialmediaapp.repository

import com.sc941737.socialmediaapp.repository.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val USERS = "/users"
private const val POSTS = "/posts"
private const val COMMENTS = "/comments"
private const val ALBUMS = "/albums"
private const val PHOTOS = "/photos"

private const val ID = "id"
private const val POST_ID = "postId"
private const val USER_ID = "userId"
private const val ALBUM_ID = "albumId"

interface SocialApi {

    @GET(USERS)
    suspend fun fetchUserOfId(
        @Query(ID) id:Long
    ):Response<User>

    @GET(POSTS)
    suspend fun fetchAllPosts():Response<List<Post>>

    @GET(COMMENTS)
    suspend fun fetchAllCommentsForPost(
        @Query(POST_ID) postId:Long
    ):Response<List<Comment>>

    @GET(ALBUMS)
    suspend fun fetchAllAlbumsForUser(
        @Query(USER_ID) userId:Long
    ):Response<List<Album>>

    @GET(PHOTOS)
    suspend fun fetchAllPhotosForAlbum(
        @Query(ALBUM_ID) albumId:Long
    ):Response<List<Photo>>

}