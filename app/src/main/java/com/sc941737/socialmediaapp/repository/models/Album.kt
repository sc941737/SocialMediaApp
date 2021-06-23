package com.sc941737.socialmediaapp.repository.models

data class Album (
    val userId:Long,
    val id:Long,
    val title:String,
    val photos:List<Photo>
)