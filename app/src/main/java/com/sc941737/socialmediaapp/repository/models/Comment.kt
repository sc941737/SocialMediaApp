package com.sc941737.socialmediaapp.repository.models

data class Comment(
    val postId:Long,
    val id:Long,
    val name:String,
    val email:String,
    val body:String
)
