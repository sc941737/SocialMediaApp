package com.sc941737.socialmediaapp.util

import android.view.View
import android.widget.Toast

fun View.shortToast(message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun View.notImplemented(){
    shortToast("Not implemented")
}