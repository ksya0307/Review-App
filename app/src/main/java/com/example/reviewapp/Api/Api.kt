package com.example.reviewapp.Api

import com.example.reviewapp.Responses.ReviewsResponses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {

    @Headers("Content-Type: application/json")
    @GET("allreviews")
    fun allreviews():Call<List<ReviewsResponses>>

}