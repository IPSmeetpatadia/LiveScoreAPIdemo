package com.example.livescoreapidemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.news.Category
import com.example.livescoreapidemo.dataclasses.news.HomepageArticle
import kotlinx.android.synthetic.main.single_view_home_article_title.view.*

class HomeArticleTitleAdapter(val context: Context, private val articleTitleList: List<HomepageArticle>, private val listener: OnArticleCategoryClick)
    : RecyclerView.Adapter<HomeArticleTitleAdapter.ArticleTitleViewHolder>() {

    class ArticleTitleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val articleTitle: TextView = itemView.txt_homeArticleTitle
        val recyclerviewArticle: RecyclerView = itemView.recyclerView_homeArticles_news
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleTitleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_home_article_title, parent, false)
        return ArticleTitleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleTitleList.size
    }

    override fun onBindViewHolder(holder: ArticleTitleViewHolder, position: Int) {
        holder.apply {
            articleTitle.text = articleTitleList[position].category.initialTitle + " news"

            recyclerviewArticle.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerviewArticle.adapter = HomeArticleNewsAdapter(context, articleTitleList[position].articles)
            recyclerviewArticle.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

            itemView.setOnClickListener {
                listener.clickedArticleCategories(articleTitleList[position].category)
            }
        }
    }

    interface OnArticleCategoryClick {
        fun clickedArticleCategories(category: Category)
    }

}