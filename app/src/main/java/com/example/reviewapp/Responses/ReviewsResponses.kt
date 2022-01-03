package com.example.reviewapp.Responses

import com.example.reviewapp.Models.Review
import com.example.reviewapp.Models.Users
import com.google.gson.annotations.SerializedName

data class ReviewsResponses(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("user")
    val user: Users,
    @SerializedName("review")
    val review: Review
)