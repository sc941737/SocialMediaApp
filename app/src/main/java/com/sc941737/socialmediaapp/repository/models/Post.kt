package com.sc941737.socialmediaapp.repository.models

data class Post (
    val userId:Long,
    val authorName:String,
    val id:Long,
    val title:String,
    val body:String
){
    constructor(postResponse: PostResponse, userResponse: UserResponse) : this(
        userId = postResponse.userId,
        authorName = userResponse.name,
        id = postResponse.id,
        title = postResponse.title,
        body = postResponse.body
    )
}