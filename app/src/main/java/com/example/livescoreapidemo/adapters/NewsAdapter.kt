package com.example.livescoreapidemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.news.TopStory
import kotlinx.android.synthetic.main.single_view_news.view.*

class NewsAdapter(val context: Context, private val newsList: List<TopStory>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val newsImg: ImageView = itemView.imgView_news
        val newsHeading: TextView = itemView.txt_newsHeading
        val newsCategory: TextView = itemView.txt_newsCategory
        val newsTiming: TextView = itemView.txt_newsTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.apply {
            Glide.with(context).load(newsList[position].mainMedia.gallery.url).into(newsImg)
            newsHeading.text = newsList[position].title
            newsCategory.text = newsList[position].categoryLabel
            var str = ""
            if (newsList[position].updatedAt.unit == "news.minutes")
            {
                str = " minute"
            } else if (newsList[position].updatedAt.unit == "news.hours") {
                str = " hours"
            } else if (newsList[position].updatedAt.unit == "news.hour") {
                str = " hour"
            }
            else if ((newsList[position].updatedAt.unit == "news.day") && (newsList[position].updatedAt.time > 1.toString())) {
                str = " Days ago"
            } else if ((newsList[position].updatedAt.unit == "news.day") && (newsList[position].updatedAt.time == 1.toString())) {
                str = " Day ago"
            }
            newsTiming.text = newsList[position].updatedAt.time + str
        }
    }

}