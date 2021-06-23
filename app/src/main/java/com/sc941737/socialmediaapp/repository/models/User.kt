package com.sc941737.socialmediaapp.repository.models

data class User (
    val id:Long,
    val name:String,
    val username:String,
    val email:String,
    val albums:List<Album>
)