package com.example.reviewapp.Models

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("date")
    val date:String?,
    @SerializedName("show")
    val show: Shows,
    @SerializedName("review")
    val review: String?
)
