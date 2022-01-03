package com.example.reviewapp.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private lateinit var apiService:Api

    fun getApiService():Api{

        val baseURL = "https://3cd1-31-204-181-129.ngrok.io"

        if(!::apiService.isInitialized){
            val retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiService = retrofit.create(Api::class.java)

        }

        return  apiService
    }
}