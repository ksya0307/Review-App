package com.example.reviewapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.reviewapp.Responses.ReviewsResponses

import kotlinx.android.synthetic.main.post_in_list.view.*


class PostAdapter(val context: Context, private val reviewsList:List<ReviewsResponses>):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(val context: Context, view:View):RecyclerView.ViewHolder(view) {
        val image: ImageView = view.showImage
        val name: TextView = view.showName
        val date: TextView = view.postDate
        val login: TextView = view.login
        val nickname:TextView = view.nickname
        val post:LinearLayout = view.post
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
        return PostViewHolder(context,
        LayoutInflater.from(context).inflate(R.layout.post_in_list,parent,false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        var requestOptions: RequestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterCrop() , RoundedCorners(7))

        val listItem = reviewsList[position]
        holder.nickname.text = reviewsList[position].user.nickname
        holder.login.text ="@${reviewsList[position].user.login}"
        holder.name.text = reviewsList[position].review.name
        holder.date.text = reviewsList[position].review.date
        Glide.with(context).load(reviewsList[position].review.show.photo).apply(requestOptions).into(holder.image)

        holder.post.setOnClickListener {

            val intent = Intent(context, Post::class.java)
            intent.putExtra("nickname", reviewsList[position].user.nickname)
            intent.putExtra("login", reviewsList[position].user.login)
            intent.putExtra("photo", reviewsList[position].review.show.photo)
            intent.putExtra("review", reviewsList[position].review.review)
            intent.putExtra("date", reviewsList[position].review.date)
            intent.putExtra("name", reviewsList[position].review.name)
            context.startActivity(intent)
        }




    }

    override fun getItemCount(): Int = reviewsList.size

}