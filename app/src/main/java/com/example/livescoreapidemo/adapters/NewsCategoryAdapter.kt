package com.example.livescoreapidemo.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.news.Category
import kotlinx.android.synthetic.main.single_item_news_categories.view.*

class NewsCategoryAdapter(val context: Context, private val newsCategoryList: List<Category>, val itemClick: OnCategoryClick) : RecyclerView.Adapter<NewsCategoryAdapter.NewsViewHolder>() {

    var selectedItem = -1

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.txt_newCategoryName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.single_item_news_categories, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsCategoryList.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.apply {
            categoryName.text = newsCategoryList[position].initialTitle

            categoryName.setOnClickListener {
                itemClick.clickedCategories(newsCategoryList[position])
                selectedItem = position
                notifyDataSetChanged()
            }

            if (selectedItem == position) {
                categoryName.setBackgroundColor(Color.parseColor("#3C000000"))
                categoryName.setTextColor(Color.parseColor("#FFFFFFFF"))
            } else {
                categoryName.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                categoryName.setTextColor(Color.parseColor("#FF000000"))
            }
        }
    }

    interface OnCategoryClick {
        fun clickedCategories(category: Category)
    }
}
