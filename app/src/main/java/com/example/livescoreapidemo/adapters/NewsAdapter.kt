package com.example.livescoreapidemo.adapters

import android.content.Context
import android.os.Build
import android.util.Log
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
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit
import kotlin.math.abs

class NewsAdapter(val context: Context, val newsList: List<TopStory>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val news_img: ImageView = itemView.imgView_news
        val news_heading: TextView = itemView.txt_newsHeading
        val news_category: TextView = itemView.txt_newsCategory
        val news_timing: TextView = itemView.txt_newsTime
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
            Glide.with(context).load(newsList[position].mainMedia.gallery.url).into(news_img)
            news_heading.text = newsList[position].title
            news_category.text = newsList[position].categoryLabel
            var str:String = ""
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
            news_timing.text = newsList[position].updatedAt.time + str
        }
    }
}