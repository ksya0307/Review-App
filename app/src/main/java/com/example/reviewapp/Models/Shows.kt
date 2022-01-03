package com.example.reviewapp.Models

import com.google.gson.annotations.SerializedName

data class Shows(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("photo")
    val photo:String?,
    @SerializedName("category")
    val category: Category
)