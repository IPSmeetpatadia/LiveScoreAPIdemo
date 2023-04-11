package com.example.livescoreapidemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.news.Tag

class NewsTagAdapter(val context: Context, private val tagList: List<Tag>): RecyclerView.Adapter<NewsTagAdapter.TagViewHolder>() {

    class TagViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtTag: TextView = itemView.findViewById(R.id.txt_newsTag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_news_tag, parent, false)
        return TagViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.apply {
            txtTag.text = tagList[position].title
        }
    }
}