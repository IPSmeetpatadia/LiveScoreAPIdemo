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
import com.example.livescoreapidemo.dataclasses.specificNews.Data
import kotlinx.android.synthetic.main.single_view_news.view.*

class NewsSpecificAdapter(val context: Context, private val newsList: List<Data>, private val itemClick: OnNewsClick)
    : RecyclerView.Adapter<NewsSpecificAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val newsImg: ImageView = itemView.imgView_news
        val newsHeading: TextView = itemView.txt_newsHeading
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
            Glide.with(context).load(newsList[position].image.data.urls.uploaded.gallery).into(newsImg)
            newsHeading.text = newsList[position].title
            newsTiming.text = newsList[position].updated_at

            itemView.setOnClickListener {
                itemClick.clickedNews(newsList[position])
            }
        }
    }

    interface OnNewsClick {
        fun clickedNews(data: Data)
    }

}