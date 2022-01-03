package com.example.reviewapp.Models

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("nickname")
    val nickname:String?,
    @SerializedName("login")
    val login:String?,
    @SerializedName("password")
    val password:String?)