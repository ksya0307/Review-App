package com.example.reviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_post.*

class Post : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        getPost()
    }

    private fun getPost(){
        if(intent.hasExtra("nickname")
            && intent.hasExtra("login")
            && intent.hasExtra("review")
            && intent.hasExtra("date")
            && intent.hasExtra("photo")
            && intent.hasExtra("name")
        ){

            nickname.text = intent.getStringExtra("nickname")
            login.text = intent.getStringExtra("login")
            postDate.text = intent.getStringExtra("date")
            showName.text = intent.getStringExtra("name")
            review.text = intent.getStringExtra("review")

            var requestOptions: RequestOptions = RequestOptions()
            requestOptions = requestOptions.transform(CenterCrop() , RoundedCorners(7))

            Glide.with(this).load(intent.getStringExtra("photo")).apply(requestOptions).into(showImage)
        }
    }
}