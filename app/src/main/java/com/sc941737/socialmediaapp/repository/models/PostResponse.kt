package com.sc941737.socialmediaapp.repository.models

data class PostResponse(
    val userId:Long,
    val id:Long,
    val title:String,
    val body:String
)
