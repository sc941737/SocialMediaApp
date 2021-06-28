package com.sc941737.socialmediaapp.repository.models

data class User (
    val id:Long,
    val name:String,
    val username:String,
    val email:String,
    val albums:List<Album>
){
    constructor(userResponse: UserResponse, albums: List<Album>):this(
        id = userResponse.id,
        name = userResponse.name,
        username = userResponse.username,
        email = userResponse.email,
        albums = albums
    )
}