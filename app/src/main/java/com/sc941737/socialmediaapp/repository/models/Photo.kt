package com.sc941737.socialmediaapp.repository.models

data class Photo(
    val albumId:Long,
    val id:Long,
    val title:String,
    val url:String,
    val thumbnailUrl:String
)
