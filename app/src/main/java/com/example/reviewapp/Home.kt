package com.example.reviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewapp.Api.ApiClient
import com.example.reviewapp.Models.Review
import com.example.reviewapp.Responses.ReviewsResponses
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_home.*
import java.io.InputStreamReader
import java.lang.reflect.Type


class Home : AppCompatActivity() {
//
//    lateinit var post: ArrayList<ReviewsResponses>()
    lateinit var apiClient: ApiClient
    private var postList=  ArrayList<ReviewsResponses>()
    lateinit var adapter: PostAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        getPosts()

    }

    private fun getPosts(){
        apiClient = ApiClient()

        apiClient.getApiService().allreviews().enqueue(object :Callback<List<ReviewsResponses>>{
            override fun onResponse(
                call: Call<List<ReviewsResponses>>,
                response: Response<List<ReviewsResponses>>
            ) {
                if(response.isSuccessful && response.body()!=null){

                    val reviewResponse = response.body()
                    if (reviewResponse != null) {
                        for(item in reviewResponse.iterator()){
                            postList.add(item)
                            adapter = PostAdapter(applicationContext, postList)
                            recyclerView.adapter = adapter
                        }
                        postList.forEach{ i ->
                            println("user ${i.user.login} review ${i.review.show.name}" )
                        }
                    }
                }


            }

            override fun onFailure(call: Call<List<ReviewsResponses>>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }
}