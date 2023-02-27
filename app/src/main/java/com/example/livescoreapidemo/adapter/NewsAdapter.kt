package com.example.livescoreapidemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.news.Category
import kotlinx.android.synthetic.main.single_item_news_categories.view.*

class NewsAdapter(val context: Context, private val newsCategoryList: List<Category>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.txt_newCategoryName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_item_news_categories, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsCategoryList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.apply {
            categoryName.text = newsCategoryList[position].initialTitle
        }
    }
}

