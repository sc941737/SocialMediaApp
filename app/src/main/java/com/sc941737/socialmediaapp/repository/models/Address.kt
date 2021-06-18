package com.sc941737.socialmediaapp.repository.models

data class Address (
    val street:String,
    val suite:String,
    val city:String,
    val zipcode:String,
    val geo:Map<String, String>
)
